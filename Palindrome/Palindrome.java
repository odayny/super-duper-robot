/** pring 8 digits palindromes 
found this on some mock interview https://www.youtube.com/watch?v=L0sZqKFzCBs

note: until it's a getting a math problem its veeery easy
*/

public class Palindrome {
    public static void main(String[] args) {
        int length = 8 ; //input

        int half = length / 2 ;
        int start = (int)Math.pow(10, half-1);
        int end = (int)Math.pow(10, half);
        for (int number = start; number < end; number++) {
            int res = number * end;
            for (int base = 1; base <= half; base++) {
                res +=((number%(int)Math.pow(10, base))/((int)Math.pow(10, base-1)))*((int)Math.pow(10, half-base));
            }
            System.out.println(res );
        }
    }
}
