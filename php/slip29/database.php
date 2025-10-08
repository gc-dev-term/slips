<?php
$db=pg_connect("host=172.16.6.1 dbname=php21200 user=php21200 password=''");
$title=$_POST['title'];
if($db)
echo "connect <br>";
else
echo "error";
$q="update committee set status='working' where cno=(select cno from evecom1 where
eno=(select eno from event where title='$title'));";
$r=pg_exec($db,$q);
if($r)
echo "Record is updated sucessfuly!";
else
echo "Error";
?>

*/

create table event(eno int primary key, title varchar(20), edate date);
insert into event values(1,'birthday','10-june-2023');
insert into event values(2,'marrige','15-july-2023');
insert into event values(3,'anniversary','13-june-2023');
insert into event values(4,'birthday','10-september-2023');

create table committee(cno int primary key, name varchar(20),head varchar(15),fromtime time,totime time,status varchar(10));
insert into committee values(1,'decoration','Mr.Kadam','02:30:00','05:30:00','Working');
insert into committee values(2,'food','Mr. jadhav ','06:30:00','09:30:00','Done');
insert into committee values(3,'cleaning','Mr. unde','09:30:00','10:30:00','Incomplete);

create table evecom1(eno int references event(eno) on delete cascade on update set None, cno int references committee(cno) on delete cascade on update set None);
insert into evecom1 values (1,1);
insert into evecom1 values (2,2);
insert into evecom1 values (3,3);
insert into evecom1 values (4,1);
insert into evecom1 values (1,2);

/*