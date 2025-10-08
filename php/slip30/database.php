<?php
$db=pg_connect("host=172.16.6.1 dbname=php21200 user=php21200 password=''");
$cname=$_POST['cname'];
if($db)
echo "connect <br>";
else
echo "error";
$q="select student.sid,name,class from student,competition,studcomp where student.sid=studcomp.sid and competition.cno=studcomp.cno and rank=1 and cname='$cname'";
$r=pg_exec($db,$q);
echo "<h1 align=center> Student who has secured 1st rank </h1>";
echo "<table border=2 bgcolor=red align=center>";
echo "<tr> <th> sno </th> <th> sname </th> <th> class </th></tr>";
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

create table student(sid int primary key,name varchar(20),class varchar(10));
insert into student values(1,'kishor','fybcs');
insert into student values(2,'amol','sybcs');
insert into student values(3,'suhas','tybcs');
insert into student values(4,'rani','fybcs');
insert into student values(5,'gauri','sybcs');

create table competition(cno int primary key, cname varchar(20),type varchar(15));
insert into competition values(1,'quiz','individual');
insert into competition values(2,'khokho','group');
insert into competition values(3,'running','individual');
insert into competition values(4,'basketball','group');
insert into competition values(5,'football','group');

create table studcomp(sid int references student(sid) on delete cascade on update set None, cno int references competition(cno) on delete cascade on update set None,rank int, year int);
insert into studcomp values(1,4,1,2021);
insert into studcomp values(2,3,2,2022);
insert into studcomp values(3,2,3,2023);
insert into studcomp values(4,1,2,2023);
insert into studcomp values(5,5,1,2023);

/*