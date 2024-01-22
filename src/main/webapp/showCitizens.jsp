
<%@page import="java.util.List"%>
<%@page import="com.hackaboss.pruebatec2.models.Citizen"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <!-- Validacion de sessión -->
        <% HttpSession mysession = request.getSession();
            String user = (String) request.getSession().getAttribute("user");

            if (user == null) {
                response.sendRedirect("login.jsp");
            }
        %>
        <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
            <div class="container-md">
                <a class="navbar-brand" href="index.jsp">
                    <img src="img/GPDSMALL.webp" alt="Gotham Police" width="80rem" />
                </a>
                <a class="navbar-brand" href="login.jsp"> Administrador </a>
                <a class="navbar-brand" href="home.jsp"> Ciudadano </a>
            </div>
        </nav>
        <div class="container">
            <h2>Ciudadanos</h2>
            <table id="citizenTable" class="table table-striped align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Edad</th>
                        <th>Identificacion</th>
                    </tr>
                </thead>

                <%
                    List<Citizen> citizenList = (List) request.getSession().getAttribute("citizenList");
                %>

                <tbody>
                    <% if (citizenList != null) 
                        for (Citizen citizen : citizenList) {%>

                    <tr>
                        <td><%=citizen.getId()%></td>
                        <td><%=citizen.getName()%></td>
                        <td><%=citizen.getAge()%></td>
                        <td><%=citizen.getIdentification()%>
                        </td>
                    </tr>
                    <%}
                    %>
                </tbody>

            </table>
        </div>
        <div class="container">
            <a href="editTurn.jsp" class="btn btn-dark btn-lg">Volver atrás</a>
        </div>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</html>
