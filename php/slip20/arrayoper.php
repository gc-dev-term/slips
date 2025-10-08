<?php
$op=$_POST['op'];
$data=array("Sagar"=>"30","Vicky"=>"41","Leena"=>"39","Ramesh"=>"40","gautam"=>"45",
"gajanan"=>"50");
switch($op)
{
case 'a':
echo "Original Array data :<br>";
print_r($data);
$result=array_chunk($data,2);
echo "<br> Split an array into chunks :<br>" ;
print_r($result);
break;
case 'b':
echo "Original Array data :<br>";
print_r($data);
asort($data);
echo "<br> Sort the array by values without changing the keys. :<br>" ;
print_r($data);
break;
case 'c': echo "Original Array data :<br>";
print_r($data);
function iseven($element)
{
return($element%2==0);
}
$even=array_filter($data, "iseven");
echo "<br> Filter the even elements from an array. :<br>" ;
print_r($even);
break;
case 'default':
echo "Enter correct option"; break;
}
?>