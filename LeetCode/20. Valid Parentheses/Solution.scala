/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
import scala.collection.mutable.Stack

object Solution {
    def isValid(s: String): Boolean = {
        val charMap = Map ('{' -> '}',
                           '(' -> ')',
                           '[' -> ']')
        var st = Stack[Char]()
        for (ch <- s) {
            if (charMap.contains(ch)) {
                st.push(ch) 
            } else if (!st.isEmpty && charMap(st.top) == ch) {
                st.pop
            } else {
                return false
            }                           
        }
        st.isEmpty
    }
}
