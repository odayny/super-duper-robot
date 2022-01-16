public class PalindromeWithRemoval {
    /*
    Given a string and the ability to delete at most one character, return whether or not it can form a palindrome.
    Note: a palindrome is a sequence of characters that reads the same forwards and backwards.

    Ex: Given the following strings...

    "abcba", return true
    "foobof", return true (remove the first 'o', the second 'o', or 'b')
    "abccab", return false
     */
    public static void main(String[] args) {
        System.out.println(new PalindromeWithRemoval().check("abcba"));
        System.out.println(new PalindromeWithRemoval().check("foobof"));
        System.out.println(new PalindromeWithRemoval().check("abccab"));
        
    }

    /*
     * recursion warning, lol
     * lets take 'foabaxof' as example
     * start check as a regular palingdrome task
     * 
     * > foabaxof
     * > ^      ^
     * 
     * to check rest of the string - use recursion
     * 
     * > oabaxo
     * > ^    ^
     * 
     * but allow one failure by moving pointers by one char
     * > abax  -> abax  or abax
     * > ^  ^     ^ ^       ^ ^
     * 
     * 
     * 
     * Optimization points:
     * - do not create a substring, use pointers
     * - swith to while loop instead of recursion
     */
    private boolean check(String s) {
        return check(s, true);
    }

    private boolean check(String s, boolean remove) {
        int n = s.length();
        if (n < 2) return true;
        if (s.charAt(0) == s.charAt(n-1)) {
            return check(s.substring(1, n-1), remove);
        } else if (remove) {
            if (n < 3) return true;
            return check(s.substring(2, n-1), false) || check(s.substring(1, n-2), false);
        }
        return false;
    }
}
