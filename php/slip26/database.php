<?php
$db=pg_connect("host=172.16.6.1 dbname=php21200 user=php21200 password=''");
$hname=$_POST['hname'];
if($db)
echo "connect <br>";
else
echo "error";
$q="select doctor.docno,dname from doctor,hospital where hospital.hospno=doctor.hospno and hname='$hname';";
$r=pg_exec($db,$q);
echo "<h1 align=center> Doctor visiting to the Hospital </h1>";
echo "<table border=2 bgcolor=red align=center>";
echo "<tr> <th> Doctor No </th> <th> Doc Name </th> <th> City </th></tr>";
while ($row=pg_fetch_array($r))
{
echo "<tr>";
echo "<td> $row[0] </td>";
echo "<td> $row[1] </td>";
echo "<td> $row[2] </td>";
echo "</tr>";
}
echo "</table>";
pg_close($db);
?>

*/

create table hospital(hospno int primary key,hname varchar(20),hcity varchar(10));

insert into hospital values(1,'life line','baramati');
insert into hospital values(2,'star','pune');
insert into hospital values(3,'city care','baramati');
insert into hospital values(4,'life care','pune');
insert into hospital values(5,'shree','baramati');

create table doctor(docno int primary key,dname varchar(20),address varchar(10),city varchar(10),area varchar(10),hospno int references hospital(hospno) on delete cascade on update set None );

insert into doctor values(1,'dhane','station rd','baramati','rural',1);
insert into doctor values(2,'kudale','cinema rd','pune','urban',2);
insert into doctor values(3,'joshi','main rd','baramati','rural',3);
insert into doctor values(4,'wable','cinema rd','pune','urban',4);
insert into doctor values(5,'rode','station rd','baramati','rural',5);


/*