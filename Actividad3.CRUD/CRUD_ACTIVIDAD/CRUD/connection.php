<?php

function connection(){
    $host = "localhost:3306";
    $user = "root";
    $pass = "root";

    $bd = "portfolio_projects";

    $connect=mysqli_connect($host, $user, $pass);

    if (!$connect) {
        die("Error al conectar a la base de datos: " . mysqli_connect_error());
    }

    if (!mysqli_select_db($connect, $bd)) {
        die("Error al seleccionar la base de datos: " . mysqli_error($connect));
    }

    return $connect;

}


?>
