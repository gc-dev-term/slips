<?php
if (isset($_POST['submit'])) {
    $large = $_POST['large'];
    $small = $_POST['small'];

    echo "<h3>Results:</h3>";

    if (stripos($large, $small) === 0) {
        echo "a) The small string appears at the start of the large string.<br>";
    } else {
        echo "a) The small string does NOT appear at the start of the large string.<br>";
    }

    // b) Find position of small string in large string
    $pos = stripos($large, $small);
    if ($pos !== false) {
        echo "b) The small string appears at position: $pos<br>";
    } else {
        echo "b) The small string does not appear in the large string.<br>";
    }

    // c) Compare first n characters (case-insensitive)
    $large_sub = substr($large, 0,1);
    $small_sub = substr($small, 0,1);

    if (strcasecmp($large_sub, $small_sub) == 0) {
        echo "c) The first characters of both strings are equal (case-insensitive).<br>";
    } else {
        echo "c) The first characters of both strings are NOT equal.<br>";
    }
}
?>