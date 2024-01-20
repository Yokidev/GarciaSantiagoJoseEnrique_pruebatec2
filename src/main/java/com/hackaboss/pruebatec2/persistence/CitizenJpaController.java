/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaboss.pruebatec2.persistence;

import com.hackaboss.pruebatec2.models.Citizen;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.hackaboss.pruebatec2.models.Turn;
import com.hackaboss.pruebatec2.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jegs_
 */
public class CitizenJpaController implements Serializable {

    public CitizenJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CitizenJpaController() {
        emf = Persistence.createEntityManagerFactory("TurneroPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Citizen citizen) {
        if (citizen.getTurnList() == null) {
            citizen.setTurnList(new ArrayList<Turn>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turn> attachedTurnList = new ArrayList<Turn>();
            for (Turn turnListTurnToAttach : citizen.getTurnList()) {
                turnListTurnToAttach = em.getReference(turnListTurnToAttach.getClass(), turnListTurnToAttach.getId());
                attachedTurnList.add(turnListTurnToAttach);
            }
            citizen.setTurnList(attachedTurnList);
            em.persist(citizen);
            for (Turn turnListTurn : citizen.getTurnList()) {
                Citizen oldCitizenOfTurnListTurn = turnListTurn.getCitizen();
                turnListTurn.setCitizen(citizen);
                turnListTurn = em.merge(turnListTurn);
                if (oldCitizenOfTurnListTurn != null) {
                    oldCitizenOfTurnListTurn.getTurnList().remove(turnListTurn);
                    oldCitizenOfTurnListTurn = em.merge(oldCitizenOfTurnListTurn);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Citizen citizen) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Citizen persistentCitizen = em.find(Citizen.class, citizen.getId());
            List<Turn> turnListOld = persistentCitizen.getTurnList();
            List<Turn> turnListNew = citizen.getTurnList();
            List<Turn> attachedTurnListNew = new ArrayList<Turn>();
            for (Turn turnListNewTurnToAttach : turnListNew) {
                turnListNewTurnToAttach = em.getReference(turnListNewTurnToAttach.getClass(), turnListNewTurnToAttach.getId());
                attachedTurnListNew.add(turnListNewTurnToAttach);
            }
            turnListNew = attachedTurnListNew;
            citizen.setTurnList(turnListNew);
            citizen = em.merge(citizen);
            for (Turn turnListOldTurn : turnListOld) {
                if (!turnListNew.contains(turnListOldTurn)) {
                    turnListOldTurn.setCitizen(null);
                    turnListOldTurn = em.merge(turnListOldTurn);
                }
            }
            for (Turn turnListNewTurn : turnListNew) {
                if (!turnListOld.contains(turnListNewTurn)) {
                    Citizen oldCitizenOfTurnListNewTurn = turnListNewTurn.getCitizen();
                    turnListNewTurn.setCitizen(citizen);
                    turnListNewTurn = em.merge(turnListNewTurn);
                    if (oldCitizenOfTurnListNewTurn != null && !oldCitizenOfTurnListNewTurn.equals(citizen)) {
                        oldCitizenOfTurnListNewTurn.getTurnList().remove(turnListNewTurn);
                        oldCitizenOfTurnListNewTurn = em.merge(oldCitizenOfTurnListNewTurn);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = citizen.getId();
                if (findCitizen(id) == null) {
                    throw new NonexistentEntityException("The citizen with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Citizen citizen;
            try {
                citizen = em.getReference(Citizen.class, id);
                citizen.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The citizen with id " + id + " no longer exists.", enfe);
            }
            List<Turn> turnList = citizen.getTurnList();
            for (Turn turnListTurn : turnList) {
                turnListTurn.setCitizen(null);
                turnListTurn = em.merge(turnListTurn);
            }
            em.remove(citizen);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Citizen> findCitizenEntities() {
        return findCitizenEntities(true, -1, -1);
    }

    public List<Citizen> findCitizenEntities(int maxResults, int firstResult) {
        return findCitizenEntities(false, maxResults, firstResult);
    }

    private List<Citizen> findCitizenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Citizen.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Citizen findCitizen(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Citizen.class, id);
        } finally {
            em.close();
        }
    }

    public int getCitizenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Citizen> rt = cq.from(Citizen.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Citizen findCitizenByIdentification(String identification){
        EntityManager em = getEntityManager();
        try{
            String queryString = "SELECT * FROM citizen WHERE identification="+"'"+identification+"'";
            Query query = em.createNativeQuery(queryString,Citizen.class);
          Citizen citizen=(Citizen) query.getSingleResult();
          return citizen;
        }finally{
            em.close();
        }
    }
    
}
