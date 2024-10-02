<?php 

$mnsConexion= ''; //Variable de conexion declarada e inicializada. Se declara fuera porque la emplearemos como variable global en las dos funciones
$mnsClase = ''; //Variable que controla la clase del mensaje de conexion

function connection(){

    global $mnsConexion;// Hace falta declararla como variable global
    global $mnsClase; //Idem


    $host = "localhost:3306";
    $user = "root";
    $pass = "root";

    $bd = "northwind";

    $connect=mysqli_connect($host, $user, $pass);

    

    //Incorporo comprobación de si la conexión es o no exitosa
    if (!$connect) {
        $mnsConexion = "Error de conexión: " . mysqli_connect_error(); // Asignamos el mensaje a la variable
        $mnsClase ="conexion-error"; //Se asigna la clase de error
        die($mnsConexion);// Detiene la ejecución
    } else {
        $mnsConexion= "¡Conexión exitosa!"; 
        $mnsClase ="conexion-exitosa"; //Se asigna la clase de éxito
    }

    // Forzar a usar UTF-8 y no salgan carácteres extraños
    mysqli_set_charset($connect, "utf8");
    mysqli_select_db($connect, $bd);

    return $connect;

}

function getText(){
    global $mnsConexion;
    global $mnsClase;
    return ['text' => $mnsConexion, 'class' => $mnsClase]; // se retorna un array con el texto y la clase
}


?>
