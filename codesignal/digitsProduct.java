/*
Given an integer product, find the smallest positive (i.e. greater than 0) integer the product of whose digits is equal to product. If there is no such integer, return -1 instead.

Example

For product = 12, the output should be
digitsProduct(product) = 26;
For product = 19, the output should be
digitsProduct(product) = -1.
Input/Output

[execution time limit] 3 seconds (java)

[input] integer product

Guaranteed constraints:
0 ≤ product ≤ 600.

[output] integer

*/

int digitsProduct(int product) {
    List<Integer> digits = new ArrayList<>();
    if (product == 0) return 10;
    if (product < 10) return product;
    for (int digit = 9; digit > 1; digit--) {
        while (product % digit == 0) {
            product /= digit;
            digits.add(digit);
        }
    }
    int result = 0;
    for (int i = 0; i < digits.size(); i++) {
        result += digits.get(i) * Math.pow(10, i);
    }
    if (result == 0 || product != 1) {
        return -1;
    } else {
        return result;
    }
}
