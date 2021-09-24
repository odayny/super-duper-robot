/*
Given a rectangular matrix of characters, add a border of asterisks(*) to it.

Example

For

picture = ["abc",
           "ded"]
the output should be

addBorder(picture) = ["*****",
                      "*abc*",
                      "*ded*",
                      "*****"]
Input/Output

[execution time limit] 3 seconds (java)

[input] array.string picture

A non-empty array of non-empty equal-length strings.

Guaranteed constraints:
1 ≤ picture.length ≤ 100,
1 ≤ picture[i].length ≤ 100.

[output] array.string

The same matrix of characters, framed with a border of asterisks of width 1.
*/
String[] addBorder(String[] picture) {
    int arraySize = picture.length;
    int stringLenght = picture[0].length();
    String asterisks = "";
    String[] result = new String[arraySize + 2];
    for (int i = 0; i < stringLenght + 2; i++) asterisks += "*";
    result[0] = result[arraySize+1] = asterisks;
    for (int i = 0; i < arraySize; i++) result[i+1] = "*" + picture[i] + "*";
    return result;
}
