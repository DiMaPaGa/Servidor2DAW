<?php

include_once './connection.php';
$con = connection();

// Validar que el parámetro idAlumnos existe y es numérico
if (isset($_GET['idAlumnos']) && is_numeric($_GET['idAlumnos'])) {
    $idAlumnos = $_GET['idAlumnos'];


$sql="DELETE FROM portfolio_projects.alumnos WHERE idAlumnos='$idAlumnos'";
$query = mysqli_query($con, $sql);

if($query){
    Header("Location: ../index.php");
}else{
    echo "Error al eliminar registro". mysqli_error($con);
}

} else {
    echo "ID alumno no valido";
}

?>
