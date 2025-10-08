<?php
 $sentence = $_POST['sentence'];
 $word = $_POST['word'];
 $position = $_POST['position'];
 $charactersToRemove = $_POST['remove'];
 $replacePosition = $_POST['replacePosition'];

 $sentence = substr_replace($sentence, '', $position, $charactersToRemove);

 $sentence = substr_replace($sentence, $word, $position, 0);

 $sentence = substr_replace($sentence, $word, $replacePosition, strlen($word));
 echo "Modified Sentence: " . $sentence;
?>