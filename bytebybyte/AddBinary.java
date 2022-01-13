package com.odayny;

public class AddBinary {
    /*Given two binary strings (strings containing only 1s and 0s) return their sum (also as a binary string).
Note: neither binary string will contain leading 0s unless the string itself is 0

Ex: Given the following binary strings...

"100" + "1", return "101"
"11" + "1", return "100"
"1" + "0", return  "1"
*/
    public static void main(String[] args) {
        System.out.println(new AddBinary().add("100", "1"));
        System.out.println(new AddBinary().add("11", "1"));
        System.out.println(new AddBinary().add("1", "0"));

    }

    private String add(String s1, String s2) {
        int s1i = s1.length() - 1, s2i= s2.length() - 1;
        int acc = 0;
        StringBuilder res = new StringBuilder();
        while (s1i >= 0 || s2i >= 0 || acc > 0) {
            if (s1i >= 0) {
                acc += s1.charAt(s1i--) - '0';
            }
            if (s2i >= 0) {
                acc += s2.charAt(s2i--) - '0';
            }

            res.insert(0, acc % 2);
            acc /= 2;
        }
        return res.toString();
    }

}
