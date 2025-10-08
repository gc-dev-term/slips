<?php
$fp=fopen("student.dat","r");
echo "<table border=2 color=red>";
echo "<tr>
<th> Roll No </th>
<th> Name </th>
<th> OS </th>
<th> WT </th>
<th> DS </th>
<th> Python </th>
<th> JAVA </th>
<th> CN </th>
<th> Total </th>
<th> Percentage</th>
</tr>";
while(($r=fscanf($fp,"%d %s %d %d %d %d %d %d"))!=false)
{
$total= $r[2]+$r[3]+$r[4]+$r[5]+$r[6]+$r[7];
$per=round(($total/6.0),2);
echo "<tr>
<td> $r[0] </td>
<td> $r[1] </td>
<td> $r[2] </td>
<td> $r[3] </td>
<td> $r[4] </td>
<td> $r[5] </td>
<td> $r[6] </td>
<td> $r[7] </td>
<td> $total </td>
<td> $per </td>
 </tr>";
}
echo "</table>";
fclose($fp);
?>