class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}
