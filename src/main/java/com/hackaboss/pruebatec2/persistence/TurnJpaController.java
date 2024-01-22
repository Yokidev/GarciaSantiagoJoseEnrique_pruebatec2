/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hackaboss.pruebatec2.persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.hackaboss.pruebatec2.models.Citizen;
import com.hackaboss.pruebatec2.models.Turn;
import com.hackaboss.pruebatec2.persistence.exceptions.NonexistentEntityException;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jegs_
 */
public class TurnJpaController implements Serializable {

    public TurnJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public TurnJpaController() {
        emf = Persistence.createEntityManagerFactory("TurneroPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turn turn) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Citizen citizen = turn.getCitizen();
            if (citizen != null) {
                citizen = em.getReference(citizen.getClass(), citizen.getId());
                turn.setCitizen(citizen);
            }
            em.persist(turn);
            if (citizen != null) {
                citizen.getTurnList().add(turn);
                citizen = em.merge(citizen);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turn turn) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turn persistentTurn = em.find(Turn.class, turn.getId());
            Citizen citizenOld = persistentTurn.getCitizen();
            Citizen citizenNew = turn.getCitizen();
            if (citizenNew != null) {
                citizenNew = em.getReference(citizenNew.getClass(), citizenNew.getId());
                turn.setCitizen(citizenNew);
            }
            turn = em.merge(turn);
            if (citizenOld != null && !citizenOld.equals(citizenNew)) {
                citizenOld.getTurnList().remove(turn);
                citizenOld = em.merge(citizenOld);
            }
            if (citizenNew != null && !citizenNew.equals(citizenOld)) {
                citizenNew.getTurnList().add(turn);
                citizenNew = em.merge(citizenNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = turn.getId();
                if (findTurn(id) == null) {
                    throw new NonexistentEntityException("The turn with id " + id + " no longer exists.");
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
            Turn turn;
            try {
                turn = em.getReference(Turn.class, id);
                turn.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turn with id " + id + " no longer exists.", enfe);
            }
            Citizen citizen = turn.getCitizen();
            if (citizen != null) {
                citizen.getTurnList().remove(turn);
                citizen = em.merge(citizen);
            }
            em.remove(turn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turn> findTurnEntities() {
        return findTurnEntities(true, -1, -1);
    }

    public List<Turn> findTurnEntities(int maxResults, int firstResult) {
        return findTurnEntities(false, maxResults, firstResult);
    }

    private List<Turn> findTurnEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turn.class));
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

    public Turn findTurn(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turn.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurnCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turn> rt = cq.from(Turn.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Turn> findTurnEntitiesByDate(LocalDate date){
        EntityManager em = getEntityManager();
        try{
            String queryString = "SELECT * FROM turn WHERE date='"+date+"';";
            Query query = em.createNativeQuery(queryString,Turn.class);
          List<Turn> list=query.getResultList();
          return list;
        }finally{
            em.close();
        }
    }


}
