<?php
$sfile=$_POST['ffile'];
$dfile=$_POST['sfile'];
$fp1=fopen($sfile,"r");
$fp2=fopen($dfile,"w");

fwrite($fp2,$d);

fwrite($fp2,fread($fp1,filesize($sfile)));
echo " $sfile file is copied into $dfile file";
fclose($fp1);
fclose($fp2);
?>