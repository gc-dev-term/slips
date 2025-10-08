<?php
$data=array("Sagar"=>"31","Vicky"=>"41","Leena"=>"39","Ramesh"=>"40");
echo " Original array is :- Sagar=>31,Vicky=>41,Leena=>39,Ramesh=>40 <br>";
echo "Ascending order sort by Value <br>";
asort($data);
foreach ($data as $k=>$v)
{
echo "$v <br>";
}
echo "Ascending order sort by Key <br>";
ksort($data);
foreach ($data as $k=>$v)
{
echo "$k <br>";
}
echo "Descending order sorting by Value <br>";
arsort($data);
foreach ($data as $k=>$v)
{
echo "$v <br>";
}
echo "Descending order sorting by Key <br>";
krsort($data);
foreach ($data as $k=>$v)
{
echo "$k <br>";
}
?>