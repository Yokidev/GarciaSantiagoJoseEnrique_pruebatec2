<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor de Turnos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
            <div class="container-md">
                <a class="navbar-brand" href="index.jsp">
                    <img src="img/GPDSMALL.webp" alt="Gotham Police" width="80rem" />
                </a>
                <a class="navbar-brand" href="home.jsp"> Ciudadano </a>
                <a class="navbar-brand" href="login.jsp"> Administrador </a>
            </div>
        </nav>

        <main>
            <div class="container">
                <h2>Registro de ciudadanos</h2>

                <p>Para pedir turno es necesario que esté registrado en el sistema.</p>
                <p>Por favor, registrese si aun no lo ha hecho.</p>

                <form action="SvCitizens" method="POST">
                    <div class="mb-3">
                        <label for="name" class="form-label">Nombre</label>
                        <input type="text" class="form-control" name="name" required />
                    </div>
                    <div class="mb-3">
                        <label for="age" class="form-label">Edad</label>
                        <input type="number" class="form-control" name="age" required />
                    </div>
                    <div class="mb-3">
                        <label for="identification" class="form-label"
                               >Identificacion</label
                        >
                        <input
                            type="text"
                            class="form-control"
                            name="identification"
                            required
                            />
                    </div>

                    <button type="submit" class="btn btn-primary">
                        Registrar ciudadano
                    </button>
                </form>
            </div>

            <br />

            <div class="container">
                <h2>Pedir turno</h2>

                <p>Recuerde que para poder ser atendido es necesario estar registrado como ciudadano.</p>

                <form action="SvTurns" method="POST">
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
                    <div class="mb-3">
                        <label for="identification">Identificacion</label>
                        <input
                            type="text"
                            class="form-control"
                            name="identification"
                            required
                            />
                    </div>

                    <br />

                    <button type="submit" class="btn btn-primary buttonColor">Agregar turno</button>
                </form>
            </div>

            <br />

            <div class="container">
                <h2>Mostrar lista de turnos</h2>
                <p>Seleccione la fecha de los turnos:</p>
                <form action="SvTurns" method="GET">
                    <input
                        type="date"
                        class="form-control"
                        name="date"
                        required
                        />
                    <div class="container form-check">
                        <p>Seleccione el fitro de estado de los turnos deseado:</p>
                            
                        <select name="state">
                            <option value="all" checked>Todos</option>
                            <option value="waiting" >En espera</option>
                            <option value="attended" >Ya atendido</option>
                        </select>
                    </div>
                    <br>
                    <input type="submit" value="Mostrar turnos" class="btn btn-success">
                </form>
            </div>
        </main>


    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</html>
