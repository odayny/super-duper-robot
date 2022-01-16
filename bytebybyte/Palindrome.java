/*
Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical characters.
Note: a palindrome is a sequence of characters that reads the same forwards and backwards.

Ex: Given the following strings...

"level", return true
"algorithm", return false
"A man, a plan, a canal: Panama.", return true
*/

import java.util.Locale;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(new Palindrome().isAPalindrome("level")); //true
        System.out.println(new Palindrome().isAPalindrome("algorithm")); //false
        System.out.println(new Palindrome().isAPalindrome("A man, a plan, a canal: Panama.")); //true
    }
    /* time O(n), space O(1).
    do a regular palindrome check but on lowercase (may be potimized by lowercasing single symbol on demand)
    and skipping non-alphabetical symbols on each iteration
    */
    public boolean isAPalindrome(String input) {
        input = input.toLowerCase(Locale.ROOT);
        int start = 0;
        int end = input.length()-1;
        while (start <= end) {
            while (input.charAt(start) < 'a' || input.charAt(start) > 'z') {
                start++;
            }
            while (input.charAt(end) < 'a' || input.charAt(end) > 'z') {
                end--;
            }
            if (input.charAt(end--) != input.charAt(start++)) {
                return false;
            }
        }
        return true;
    }
}
