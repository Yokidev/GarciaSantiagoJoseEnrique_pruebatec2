package com.hackaboss.pruebatec2.servlets;

import com.hackaboss.pruebatec2.models.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvDeleteCitizen", urlPatterns = {"/SvDeleteCitizen"})
public class SvDeleteCitizen extends HttpServlet {

    Controller control = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * *
     * Manda a la controladora la id del ciudadano que se quiere eliminar de la
     * BBDD
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idDelete = Integer.parseInt(request.getParameter("id"));

        try {
            control.deleteCitizen(idDelete);
            response.sendRedirect("editTurn.jsp");
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
