<?php
$sno = $_POST['snum'];
$sname = $_POST['sname'];
$marks = $_POST['smarks'];
$sno = explode(',',$sno);
$subname = explode(',',$sname);
$smarks = explode(',',$marks);
$total = (($smarks[0]+$smarks[1]+$smarks[2]+$smarks[3]+$smarks[4]));
$per=$total/5;
if($per>=70)
$grade="A";
elseif($per>=60)
$grade="B";
elseif($per>=50)
$grade="C";
elseif ($per>=40)
 $grade="D";
else
$grade="F";
echo "<table align=center border=1>";
echo "<tr>
<th> <b> Serial Number </b> </th>
<th> <b> Subject Name </b> </th>
<th> <b> Marks </b> </th>
</tr>";
for($i=0;$i<5;$i++)
echo "<tr>
<td>".$sno[$i]."</td>
<td>".$subname[$i]."</td>
<td>".$smarks[$i]."</td>
</tr>";
echo "<tr> <th colspan=2> Total Marks </th><td>".$total."</td> </tr>";
echo "<tr> <th colspan=2> Percentage:- </th> <td>" .$per. "</td> </tr>";
echo "<tr> <th colspan=2> Grade:- </th> <td>" .$grade. "</td> </tr>";
echo "</table>";
?>