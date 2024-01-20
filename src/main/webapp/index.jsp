<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestor de Turnos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    </head>
    <body>

        <h1>Turnero</h1>

        <div>
            <h2>Añadir Ciudadano</h2>

            <form action="SvCitizens" method="POST">

                <label for="name">Nombre</label>
                <input type="text" name="name" required>
                <br>
                <label for="age">Edad</label>
                <input type="number" name="age" required>
                <br>
                <label for="identification">Identificación</label>
                <input type="text" name="identification" required>

                <button type="submit">Agregar ciudadano</button>
            </form>
        </div>

        <div>
            <h2>Añadir turno</h2>

            <form action="SvTurns" method="POST">

                <label for="date">Fecha</label>
                <input type="datetime-local" name="date" required>
                <br>
                <label for="description">Descripcion</label>
                <input type="text" name="description" required>
                <br>
                <label for="identification">Identificacion</label>
                <input type="text" name="identification" required>

                <button type="submit">Agregar turno</button>
            </form>
        </div>

        <div>
            <form action="SvTurns" method="GET">
                <button type="submit">Mostrar turnos</button>
            </form>
        </div>


    </body>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</html>
