package com.hackaboss.pruebatec2.servlets;

import com.hackaboss.pruebatec2.models.Citizen;
import com.hackaboss.pruebatec2.models.Controller;
import com.hackaboss.pruebatec2.models.Turn;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvTurns", urlPatterns = {"/SvTurns"})
public class SvTurns extends HttpServlet {

    Controller control = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /***
     * Devuelve a la vista la lista de turnos solicitada.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LocalDate date = LocalDate.parse(request.getParameter("date"));

        String state = (String) request.getParameter("state");

        List<Turn> turnList = control.turnListFilter(date, state);
        HttpSession mySession = request.getSession();
        mySession.setAttribute("turnList", turnList);

        response.sendRedirect("showTurns.jsp");
    }

    /***
     * Comprueba si un turno esta registrado. Si no lo está, manda a la controladora los parametros para su creación.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LocalDateTime fecha = LocalDateTime.parse(request.getParameter("date"));
        String description = request.getParameter("description");
        String identification = request.getParameter("identification");

        try {
            Citizen citizen = control.findCitizenByIdentification(identification);
            if (citizen != null) {
                control.createTurn(fecha, description, identification);
                response.sendRedirect("success.jsp");
            }

        } catch (Exception e) {
            response.sendRedirect("userNotExist.jsp");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
