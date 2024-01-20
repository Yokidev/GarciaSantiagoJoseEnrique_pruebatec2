<%@page import="java.util.List"%>
<%@page import="com.hackaboss.pruebatec2.models.Turn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>
        <h1>Turnos</h1>
        
        <table id="turnTable" >
            <thead>
                <tr>
                    <th>Nº turno</th>
                    <th>Fecha</th>
                    <th>Ciudadano</th>
                    <th>Estado</th>
                </tr>
            </thead>
            
            <%
                List<Turn> turnList = (List)request.getSession().getAttribute("turnList");
            %>
            
            <tbody>
                <% for (Turn turn: turnList) {%>
                
                <tr>
                    <td><%=turn.getId()%></td>
                    <td><%=turn.getDate()%></td>
                    <td><%=turn.getCitizen().getName()%></td>
                    <td><% if ( turn.isAttended()) {
                            out.println("Ya atendido");
                        }else{
                            out.print("En espera");
                        }%>
                    </td>
                </tr>
                <%}
                %>
            </tbody>


    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</html>
