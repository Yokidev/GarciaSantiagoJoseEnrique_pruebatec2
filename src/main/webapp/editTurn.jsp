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

        <!<!-- Validacion de sessión -->
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

        <main>
            <div class="container">
                <h2>Panel administrador</h2>

                <div class="container">
                    <form action="SvCitizens" method="GET">
                        <button type="submit" class="btn btn-success">Ver ciudadanos</button>
                    </form>
                    <br />
                </div> 
                <h3 style="text-align: center;">Actualizar ciudadano</h3>
                <div class="container">
                    <form action="SvEditCitizen" method="POST" id="admin">
                        <div class="mb-3">
                            <label for="id" class="form-label">Introduce el id ciudadano</label>
                            <input type="text" class="form-control" name="id" required />
                        </div>
                        <div class="mb-3">
                            <label for="name" class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="name" required />
                        </div>
                        <div class="mb-3">
                            <label for="age" class="form-label">Edad</label>
                            <input type="number" class="form-control" name="age" required />
                        </div>
                        <div class="mb-3">
                            <label for="identification">Identificacion</label>
                            <input
                                type="text"
                                class="form-control"
                                name="identification"
                                required
                                />
                        </div>

                        <button type="submit" class="btn btn-primary">Actualizar</button>
                    </form>
                </div>

                <br>
                <br>

                <h3 style="text-align: center;">Actualizar turnos</h3>
                <form action="SvShowTurnsEdit" method="GET">
                    <button type="submit" class="btn btn-success">Ver turnos</button>
                </form>
                <br />

                <form action="SvShowTurnsEdit" method="POST" id="admin">
                    <div class="mb-3">
                        <label for="id">Nº Turno</label>
                        <input type="number" class="form-control" name="id" required />
                    </div>
                    <div class="mb-3">
                        <label>Estado:</label>
                        <select name="state">
                            <option value="waiting" >En espera</option>
                            <option value="attended" >Ya atendido</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="date">Fecha</label>
                        <input
                            type="datetime-local"
                            class="form-control"
                            name="date"
                            required
                            />
                    </div>
                    <div class="mb-3">
                        <label for="description">Descripcion</label>
                        <textarea
                            class="form-control"
                            name="description"
                            required
                            ></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Actualizar</button>
                </form>
            </div>
        </main>
    </body>
    <script
        src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"
    ></script>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"
    ></script>
</html>
