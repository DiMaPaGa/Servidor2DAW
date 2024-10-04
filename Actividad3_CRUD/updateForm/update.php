<?php 

    include_once '../CRUD/connection.php';
    $con=connection();

    if (isset($_GET['idAlumnos']) && is_numeric($_GET['idAlumnos'])) {
        $idAlumnos = $_GET['idAlumnos'];

        $sql="SELECT * FROM portfolio_projects.alumnos WHERE idAlumnos='$idAlumnos'";
    
        $query=mysqli_query($con, $sql);

        if(!$row=mysqli_fetch_array($query)){
            echo "No se encontró ningún alumno con ese ID.";
            exit;
        }
    } else {
        echo "ID inválido.";
        exit;
    }
?>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="UTF-8">
        <meta name="description" content="Este es un ejemplo crud">
        <meta name="keywords" content="html, css, bootstrap, js, portfolio, proyectos, php">
        <meta name="language" content="EN">
        <meta name="author" content="joaquin.borrego@vedruna.es">
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
        <title>Actualizar Proyecto</title>

    </head>

    <body>
        <div class="container">
            <h1 class="text-center">Actualizar</h1>
            <form action="../CRUD/edit_project.php" method="POST">
                <div class="form-group">
                    <input type="hidden" class="form-control" name="idAlumnos" value="<?= $row['idAlumnos']?>">
                </div>
                <div class="form-group">
                    <label for="name">Nombre</label>
                    <input type="text" class="form-control" id="nombreAlumnos" name="nombreAlumnos" placeholder="Nombre completo" value="<?= $row['nombreAlumnos']?>">
                </div>
                <div class="form-group">
                    <label for="edad">Edad</label>
                    <input type="text" class="form-control" id="edad" name="edad" placeholder="Edad" value="<?= $row['edad']?>">
                </div>
                
                <input type="submit" class="m-3 btn btn-primary" value="Actualizar">
            </form>
        </div>
    </body>

</html>
