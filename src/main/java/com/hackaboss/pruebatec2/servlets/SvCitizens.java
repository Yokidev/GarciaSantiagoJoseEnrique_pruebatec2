package com.hackaboss.pruebatec2.servlets;

import com.hackaboss.pruebatec2.models.Citizen;
import com.hackaboss.pruebatec2.models.Controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvCitizens", urlPatterns = {"/SvCitizens"})
public class SvCitizens extends HttpServlet {

    Controller control = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /***
     * Devuelve la lista de ciudadanos en la BBDD
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Citizen> citizenList = control.citizenList();
        
        HttpSession mySession = request.getSession();
        mySession.setAttribute("citizenList", citizenList);
        
        response.sendRedirect("showCitizens.jsp");
        

    }

    /***
     * Comprueba si un usuario esta registrado. Si no lo está, manda a la controladora los parametros para su creacion.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String identification = request.getParameter("identification");

        try {
            Citizen citizen = control.findCitizenByIdentification(identification);
            response.sendRedirect("userAlreadyRegistred.jsp");
            
        } catch (Exception e) {
            control.createCitizen(name, age, identification);
            response.sendRedirect("success.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
