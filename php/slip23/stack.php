<?php
$op=$_POST['op'];
$t1=$_POST['t1'];
$stack=array(1,2,3,4,5);
switch($op)
{
case 'a':
echo "Insert an element in stack :<br>";
array_push($stack,$t1);
var_dump($stack);
break;
case 'b':
echo "Delete an element from stack :<br>";
array_pop($stack);
var_dump($stack);
break;
case 'c':
echo "Display the contents of stack :<br>";
var_dump($stack);
break;
case 'default':
echo "Enter Correct Choice :<br>";
break;
}
?>