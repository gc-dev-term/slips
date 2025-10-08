<?php

 $num1 = (float)$_POST['num1'];
    $num2 = (float)$_POST['num2'];
    $operation = $_POST['operation'];

    $result = calculate($num1, $num2, $operation);

    echo "<h2>Result:</h2>";
    echo "First Number: $num1 <br>";
    echo "Second Number: $num2 <br>";
    echo "Operation: $operation <br>";
    echo "Result: $result <br>";

function calculate($num1 = 0, $num2 = 0, $operation = "add") {
    switch($operation) {
        case "add":
            return $num1 + $num2;
        case "subtract":
            return $num1 - $num2;
        case "multiply":
            return $num1 * $num2;
        case "divide":
            return ($num2 != 0) ? $num1 / $num2 : "Division by zero!";
        default:
            return "Invalid operation";
    }
}
?>
