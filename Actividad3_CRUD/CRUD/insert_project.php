<?php

    include_once './connection.php';
    $con = connection();

    if (isset($_POST['nombreAlumnos']) && !empty($_POST['nombreAlumnos']) && 
    isset($_POST['edad']) && is_numeric($_POST['edad'])) {

        
        $nombreAlumnos = $_POST['nombreAlumnos'];
        $edad = $_POST['edad'];

    $sql = "INSERT INTO portfolio_projects.alumnos (nombreAlumnos, edad) VALUES('$nombreAlumnos','$edad')";
    $query = mysqli_query($con, $sql);

        if($query){
            Header("Location: ../index.php");
        }else{
            echo "Error al insertar el registro: " . mysqli_error($con);
        }

    } else {
        echo "Datos inválidos proporcionados.";
    }
?>
