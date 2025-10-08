<?php
$string=$_POST['str1'];
echo "Original String is :- $string <br> <br>";
echo "To select first 5 words from the string <br><br>";
$ffivewords=substr($string,0,5);
echo "First 5 words from the string are:- $ffivewords <br> <br>";
echo "Convert the given string to lowercase and then to Title case.<br><br>";
$lcase=strtolower($string); echo "Lowercase String is :- $lcase <br><br>";
$tcase=ucwords(strtolower($string));
echo "Title case String is :- $tcase <br><br>";
echo "Pad the given string with “*” from left and right both the sides. <br><br>";
$bspad=str_pad($string,30,"*",STR_PAD_BOTH);
echo "paded string is $bspad <br> <br>";
echo "Remove the leading whitespaces from the given string.<br><br>";
$lwstring=ltrim($string);
echo "Removed leading whitespaces string is:- $lwstring <br> <br>";
echo "Find the reverse of given string.<br><br>";
$rstring=strrev($string);
echo "Reverse String is:- $rstring <br>";
?>