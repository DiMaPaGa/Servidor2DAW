<?php

include_once './CRUD/connection.php';
$con = connection();

$sql = "SELECT * FROM portfolio_projects.alumnos";
$query = mysqli_query($con, $sql);

//Incorporo comprobación por si hay error en la consulta
if (!$query) {
    die("Error en la consulta: " . mysqli_error($con));
}
?>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="description" content="Este es un ejemplo crud">
    <meta name="keywords" content="html, css, bootstrap, js, portfolio, proyectos, php">
    <meta name="language" content="EN">
    <meta name="author" content="dianamaria.pascual@a.vedrunasevillasj.es">
    <meta name="robots" content="index,follow">
    <meta name="revised" content="Tuesday, February 28th, 2023, 23:00pm">
    <meta name="viewport" content="width=device-width, initial scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE-edge, chrome1">

    <!-- Añado la fuente Roboto -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700;900&display=swap" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"
        defer></script>

    <!-- Titulo -->
    <title>CRUD Actividad </title>

</head>

<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Listado de Alumnos</h1>
    
        <table class="table table-striped table-hover table-bordered">
            <thead class="table-primary text-center">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Acciones</th> <!-- Columna para integrar las acciones -->
                </tr>
            </thead>
            <tbody>
                <?php while ($row = mysqli_fetch_array($query)): ?>
                    <tr>
                        <td class="text-center"><?= $row['idAlumnos'] ?></td>
                        <td class="text-center"><?= $row['nombreAlumnos'] ?></td>
                        <td class="text-center"><?= $row['edad'] ?></td>
                        <td class="text-center">
                            <a href="updateForm/update.php?idAlumnos=<?= $row['idAlumnos'] ?>" class="btn btn-warning btn-sm">Editar</a>
                            <a href="CRUD/delete_project.php?idAlumnos=<?= $row['idAlumnos'] ?>" class="btn btn-danger btn-sm" onclick="return confirm('¿Estás seguro de que quieres eliminar este alumno?')">Eliminar</a>
                        </td>
                    </tr>
                <?php endwhile; ?>
            </tbody>
        </table>
    </div>

    <div class="container mt-5">
        <h2 class="text-center">Insertar Alumno</h2>
        <form action="CRUD/insert_project.php" method="POST">
            <div class="form-group mb-3">
                <input type="hidden" class="form-control" name="idAlumnos">
            </div>
            <div class="form-group mb-3">
                <label for="nombreAlumnos">Nombre</label>
                <input type="text" class="form-control" id="nombreAlumnos" name="nombreAlumnos" placeholder="Nombre Completo">
            </div>
            <div class="form-group mb-3">
                <label for="edad">Edad</label>
                <input type="text" class="form-control" id="edad" name="edad" placeholder="edad">
            </div>
            
            <input type="submit" class="m-3 btn btn-primary" value="Insertar">
        </form>
    </div>

</body>

</html>