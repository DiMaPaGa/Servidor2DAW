<?php
require_once './php/connection.php';


$con = connection();

$sql = "SELECT ProductID, ProductName, UnitsInStock FROM products";
$query = mysqli_query($con, $sql);


 //Incorporo comprobación por si hay error en la consulta
 if (!$query) {
    die("Error en la consulta: " . mysqli_error($con));
}

$messageData = getText(); // Obtener tanto el mensaje como la clase
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceso a datos</title>
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>

    <div class= "conexion <?= $messageData['class'] ?>"> <!-- Aplicamos la clase -->
        <?= $messageData['text'] ?><!-- Incluimos el texto -->
    </div>
    <table>
        <thead>
            <tr class="table-primary" style="text-align: center;">
                <th>ProductID</th>
                <th>ProductName</th>
                <th>UnitsInStock</th>
            </tr>
        </thead>
        <tbody>
            <?php while ($row = mysqli_fetch_array($query)): ?>
                <tr>
                    <td><?= $row['ProductID'] ?></td>
                    <td><?= $row['ProductName'] ?></td>
                    <td><?= $row['UnitsInStock'] ?></td>
                </tr>
            <?php endwhile; ?>
        </tbody>
    </table>
    
</body>
</html>
