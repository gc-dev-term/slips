<?php
$temp=array(35,45,50,44,42,36,38,30,40,47,60,48,24,38,36);
rsort($temp);
echo "Average high temp is:- <br> <br>";
$total=array_sum($temp);
$avgtemp=round(($total/15),2);
echo "$avgtemp&deg; <br> <br>";
$t=array_slice($temp,0,5);
echo "<br> <br>Five warmest high temps :- <br> <br>";
foreach($t as $v)
echo "$v&deg <br>";
?>