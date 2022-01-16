public class Capitalization {
    /*
    Given a string, return whether or not it uses capitalization correctly. A string correctly uses capitalization if all letters are capitalized, no letters are capitalized, or only the first letter is capitalized.

    Ex: Given the following strings...

    "USA", return true
    "Calvin", return true
    "compUter", return false
    "coding", return true
     */
    public static void main(String[] args) {
        new Capitalization();
        long time = System.nanoTime();
        System.out.println(new Capitalization().check2("USA"));
        System.out.println(new Capitalization().check2("Calvin"));
        System.out.println(new Capitalization().check2("compUter"));
        System.out.println(new Capitalization().check2("coding"));
        System.out.println("Done in " + (System.nanoTime() - time) + " ns");

        time = System.nanoTime();
        System.out.println(new Capitalization().check("USA"));
        System.out.println(new Capitalization().check("Calvin"));
        System.out.println(new Capitalization().check("compUter"));
        System.out.println(new Capitalization().check("coding"));
        System.out.println("Done in " + (System.nanoTime() - time) + " ns");
        time = System.nanoTime();

        System.out.println(new Capitalization().check2("USA"));
        System.out.println(new Capitalization().check2("Calvin"));
        System.out.println(new Capitalization().check2("compUter"));
        System.out.println(new Capitalization().check2("coding"));
        System.out.println("Done in " + (System.nanoTime() - time) + " ns");

        time = System.nanoTime();
        System.out.println(new Capitalization().check("USA"));
        System.out.println(new Capitalization().check("Calvin"));
        System.out.println(new Capitalization().check("compUter"));
        System.out.println(new Capitalization().check("coding"));
        System.out.println("Done in " + (System.nanoTime() - time) + " ns");
    }

    /*
    O(n) time
    O(0) space
    
    Count all capital letter
     - if all capital - cool
     - if only one capital - check is it the one on the beginning
    */
    private boolean check(String s) {
        int upperCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upperCount++;
            }
        }
        return upperCount == 0 || upperCount == s.length() || (upperCount == 1 && Character.isUpperCase(s.charAt(0)));
    }

    /*
    O(n) time
    O(0) space
    
    Check is the 0th letter is capital
     - yes: check is whole line is capital by counting capital letters (shortcuts in code)
     - no: no capital allowed then, fail on first one.
    */
    private boolean check2(String s) {
        boolean upperAllowed = Character.isUpperCase(s.charAt(0));
        int upperCount = 0;
        for (int i = 1; i < s.length(); i++) {
            if (!upperAllowed && Character.isUpperCase(s.charAt(i))) {
                return false;
            } else {
                upperCount++;
                if (upperCount != 0 && upperCount != i) {
                    return false;
                }
            }
        }
        return true;
    }

}
