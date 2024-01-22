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
            <div class="container" >
                <h2>Login Administrador</h2>

                <form action="SvLogin" method="POST" id="login">
                    <div class="mb-3">
                        <label for="user" class="form-label">User</label>
                        <input type="text" class="form-control" name="user" required />
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label"
                               >Contraseña</label
                        >
                        <input
                            type="password"
                            class="form-control"
                            name="password"
                            required
                            />
                    </div>

                    <button type="submit" class="btn btn-primary">
                        Login
                    </button>
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
