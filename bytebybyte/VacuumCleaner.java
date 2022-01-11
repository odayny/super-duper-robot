public class VacuumCleaner {
    /*
    Given a string representing the sequence of moves a robot vacuum makes, return whether or not it will return to its original position. The string will only contain L, R, U, and D characters, representing left, right, up, and down respectively.

    Ex: Given the following strings...

    "LR", return true
    "URURD", return false
    "RUULLDRD", return true
     */

    public static void main(String[] args) {
        System.out.println(new VacuumCleaner().go("LR"));
        System.out.println(new VacuumCleaner().go("URURD"));
        System.out.println(new VacuumCleaner().go("RUULLDRD"));
    }

    private boolean go(String s) {
        int x = 0, y =0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'L': x++;
                break;
                case 'R': x--;
                break;
                case 'U': y++;
                break;
                case 'D': y--;
                break;
            }
        }
        return x == 0 && y == 0;
    }
}
