<?php $op=$_POST['op'];
$data=array("Sagar"=>"31","Vicky"=>"41","Leena"=>"39","Ramesh"=>"40");
switch($op)
{
case 'a':
echo "Original Array data :<br>";
print_r($data);
$result=array_flip($data);
echo "<br> Flipped Array data :<br>" ;
print_r($result);
break;
case 'b':
echo "Original Array data :<br>";
print_r($data);
$result=$data;
shuffle($result);
echo "<br> Shuffled Array data :<br>" ;
print_r($result);
break;
case 'c':
echo "Original Array data :<br>";
print_r($data);
$result=$data;
extract($result);
echo "<br> Extracting array elements in to individual variables :<br>" ;
echo "<br> \$Sagar = $Sagar; \$Vicky = $Vicky; \$Leena = $Leena \$Ramesh=
$Ramesh";
echo "<br> $Sagar"; break; case 'd': echo "Original Array data :<br>";
foreach($data as $k => $v)
{
echo "<br>Key is =$k value is =$v";
}
break;
}
?>