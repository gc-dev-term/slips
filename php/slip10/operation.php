<?php
if(isset($_POST['submit'])){
    $num1 = (int)$_POST['num1'];
    $num2 = (int)$_POST['num2'];

    function findMod($a, $b){
        return $a % $b;
    }

    function findPower($a, $b){
        return pow($a, $b);
    }

    function sumOfFirstN($n){
        return ($n * ($n + 1)) / 2;
    }

    function factorial($n){
        $fact = 1;
        for($i=1; $i<=$n; $i++){
            $fact *= $i;
        }
        return $fact;
    }

    echo "<h3>Results:</h3>";
    echo "a) Modulus of $num1 and $num2: " . findMod($num1, $num2) . "<br>";
    echo "b) $num1 raised to the power $num2: " . findPower($num1, $num2) . "<br>";
    echo "c) Sum of first $num1 numbers: " . sumOfFirstN($num1) . "<br>";
    echo "d) Factorial of $num2: " . factorial($num2) . "<br>";
}
?>