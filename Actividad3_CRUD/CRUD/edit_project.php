<?php

include_once './connection.php';
$con = connection();

if (isset($_POST['idAlumnos']) && is_numeric($_POST['idAlumnos']) &&
    isset($_POST['nombreAlumnos']) && isset($_POST['edad']) && is_numeric($_POST['edad'])) {


$idAlumnos=$_POST["idAlumnos"];
$nombreAlumnos = $_POST['nombreAlumnos'];
$edad = $_POST['edad'];


$sql="UPDATE portfolio_projects.alumnos SET nombreAlumnos='$nombreAlumnos', edad='$edad' WHERE idAlumnos='$idAlumnos'";
$query = mysqli_query($con, $sql);

    if($query){
        Header("Location: ../index.php");
    }else{
        echo "Error al actualizar el registro: ".mysqli_error($con);
    }

}else{
    echo "Datos inválidos proporcionados.";
    }

?>
