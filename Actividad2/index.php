<?php
require_once './php/connection.php';


$con = connection();

$sql = "SELECT ProductName, CategoryName, UnitPrice from products, categories
where products.CategoryID = categories.CategoryID and
products.UnitPrice > (SELECT AVG(p.UnitPrice) FROM Products p where p.CategoryID= products.CategoryID);";
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
                <th>ProductName</th>
                <th>CategoryName</th>
                <th>UnitPrice</th>
            </tr>
        </thead>
        <tbody>
            <?php while ($row = mysqli_fetch_array($query)): ?>
                <tr>
                    <td><?= $row['ProductName'] ?></td>
                    <td><?= $row['CategoryName'] ?></td>
                    <td><?= $row['UnitPrice'] ?></td>
                </tr>
            <?php endwhile; ?>
        </tbody>
    </table>
    
</body>
</html>
