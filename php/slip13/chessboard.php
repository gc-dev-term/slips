<!DOCTYPE html>
<html>
<head>
<style>
 table {
 border-collapse: collapse;
 }
 td {
 width: 50px;
 height: 50px;
 text-align: center;
 vertical-align: middle;
 font-size: 24px;
 }
 .white {
 background-color: #FFFFFF;
 }
 .black {
 background-color: #000000;
 }
 </style>
</head>
<body>
 <table>
 <?php
 for ($row = 1; $row <= 8; $row++)
{
 echo "<tr>";
 for ($col = 1; $col <= 8; $col++)
{
 $class = ($row + $col) % 2 == 0 ? 'white' : 'black';
 echo "<td class='$class'></td>";
 }
echo "</tr>";
}
?>
</table>
</body>
</html>