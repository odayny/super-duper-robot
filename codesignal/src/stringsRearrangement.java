/*
Given an array of equal-length strings, you'd like to know if it's possible to rearrange the order of the elements in such a way that each consecutive pair of strings differ by exactly one character. Return true if it's possible, and false if not.

Note: You're only rearranging the order of the strings, not the order of the letters within the strings!

Example

For inputArray = ["aba", "bbb", "bab"], the output should be
stringsRearrangement(inputArray) = false.

There are 6 possible arrangements for these strings:

["aba", "bbb", "bab"]
["aba", "bab", "bbb"]
["bbb", "aba", "bab"]
["bbb", "bab", "aba"]
["bab", "bbb", "aba"]
["bab", "aba", "bbb"]
None of these satisfy the condition of consecutive strings differing by 1 character, so the answer is false.

For inputArray = ["ab", "bb", "aa"], the output should be
stringsRearrangement(inputArray) = true.

It's possible to arrange these strings in a way that each consecutive pair of strings differ by 1 character (eg: "aa", "ab", "bb" or "bb", "ab", "aa"), so return true.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.string inputArray

A non-empty array of strings of lowercase letters.

Guaranteed constraints:
2 ≤ inputArray.length ≤ 10,
1 ≤ inputArray[i].length ≤ 15.

[output] boolean

Return true if the strings can be reordered in such a way that each neighbouring pair of strings differ by exactly one character (false otherwise).
*/

boolean stringsRearrangement(String[] inputArray) {
    LinkedList<String> combination = new LinkedList<>();
    combination.add(inputArray[0]);
    Queue<String> tryAgain = new LinkedList<String>();
    for(int i = 1; i < inputArray.length; i++) {
        if (fits(combination.getFirst(), inputArray[i])) {
            combination.addFirst(inputArray[i]);
        } else if (fits(combination.getLast(), inputArray[i])) {
           combination.addLast(inputArray[i]); 
        } else {
            tryAgain.add(inputArray[i]);
        }
    }
    if (tryAgain.isEmpty()) {
        return true;
    }
    int tryAgainSize = tryAgain.size();
    while (!tryAgain.isEmpty()) {   
        for (int i = 0; i < tryAgain.size(); i++) {
            String elem = tryAgain.remove();
            if (fits(combination.getFirst(), elem)) {
                combination.addFirst(elem);
            } else if (fits(combination.getLast(), elem)) {
                combination.addLast(elem); 
            } else {
                tryAgain.add(elem);
            }
        }
        if (tryAgain.size() == tryAgainSize) {
            return false;
        }
    }
    return true;
}

boolean fits(String s1, String s2) {
    int diffCount = 0;
    for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)){
            diffCount++;
        }
        if (diffCount > 1) {
            return false;
        }
    }
    return diffCount == 1;
}
