<?php
$op=$_POST['op'];
$queue=array(1,2,3,4);
switch($op)
{
case 'a':
echo "Insert an element in queue :<br>";
array_shift($queue);
var_dump($queue);
break;
case 'b':
echo "Delete an element from queue :<br>";
array_unshift($queue,100);
var_dump($queue);
break;
case 'c':
echo "Display the contents of queue :<br>";
var_dump($queue);
break;
case 'default':
echo "Enter Correct Choice :<br>";
break;
}
?>