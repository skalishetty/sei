## About
DeDup.java has 3 different methods to remove duplicate from an integer array.

## Setter
Use setRandomIntegers(int[] randomIntegers) to set the random integers with duplicate.

## Method 1
Use Case: This method uses HashSet to remove duplicate elements.
This method uses prior java1.8 version
Positive: Simple and effective way to remove duplicates integers from an array of integers.
Negative: It has cost of converting array of integers to HashSet and then HashSet to array of integers while returning.

## Method 2
Use Case: Use this method to retain original order of the integer array.
Positive: This method uses java1.8 version Stream API to remove duplicates and retain orginal order
Negative: Removing duplicates from large array of integers will take time.

## Method 3
Use Case: Use this method to parallel processing of large integer array.
Positive: This method uses java1.8 version Parallel Stream API to remove duplicates.
Negative: Original order of the integer array is not maintained.
