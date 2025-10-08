<?php
$sfile=$_POST['ffile'];
$dfile=$_POST['sfile'];
$fp1=fopen($sfile,"r");
$fp2=fopen($dfile,"a");

$d=fread($fp1,filesize($sfile));
fwrite($fp2,$d);

fwrite($fp2,fread($fp1,filesize($sfile)));
echo "Appended content of $sfile file into $dfile file";
fclose($fp1);
fclose($fp2);
?>