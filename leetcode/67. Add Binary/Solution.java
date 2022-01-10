/*Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/

class Solution {
    public String addBinary_(String a, String b) {
        int acc = 0;
        int len = Math.max(a.length(), b.length());
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int aIdx = a.length() - i - 1;
            int bIdx = b.length() - i - 1;
            int aChar = 0;
            if (aIdx >= 0) {
                aChar = a.charAt(aIdx) - '0';
            }
            int bChar = 0;
            if (bIdx >= 0) {
                bChar = b.charAt(bIdx) - '0';
            }
            int sum = acc + aChar + bChar;
            if (sum == 0) {
                acc = 0;
                res = res.insert(0, '0');
            } else if (sum == 1) {
                acc = 0;
                res = res.insert(0, '1');
            } else if (sum == 2) {
                acc = 1;
                res = res.insert(0, '0');
            } else {
                acc = 1;
                res = res.insert(0, '1');
            }
        }
        if (acc == 1) {
            res = res.insert(0, '1');
        }
        return res.toString();
    }
 
 //cleaner
     public String addBinary(String a, String b) {
        int acc = 0;
        StringBuilder res = new StringBuilder();
        int aIdx = 0;
        int bIdx = 0;
        while(aIdx < a.length() || bIdx < b.length() || acc > 0) {
            if (aIdx < a.length()) {
                acc += a.charAt(a.length() - aIdx++ - 1) - '0';
            }
            if (bIdx < b.length()) {
                acc += b.charAt(b.length() - bIdx++ - 1) - '0';
            }
            res.append(acc%2);
            acc /=2;
        }
        return res.reverse().toString();
    }
}
