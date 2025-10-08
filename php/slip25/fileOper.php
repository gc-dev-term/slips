<?php
$op=$_POST['op'];
$file=$_POST['file'];
switch($op)
{
case 'a':
$filetype=filetype($file);
echo "Type of File is:- $filetype";
break;
case 'b':
$lmodtime=filemtime($file);
echo "last modification time of file is:- $lmodtime";
break;
case 'c':
$fsize=filesize($file);
echo "Size of file is:- $fsize Bytes";
break;
case 'd':
unlink($file);
break;
case 'default':
echo "Enter correct option";
break;
}
?>