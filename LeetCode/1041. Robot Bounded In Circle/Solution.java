/*
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.
Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.
*/
class Solution {
    public boolean isRobotBounded(String s) {
        int[] vector = new int[3];
        for (int i = 0; i < s.length(); i++) {
            char command = s.charAt(i);
            if (command == 'G') {
                if (vector[2] == 0) { //NORTH
                    vector[1]++;
                } else if (vector[2] == 1) { //WEST
                    vector[0]--;
                }
                else if (vector[2] == 2) { //SOUTH
                    vector[1]--;
                }
                else if (vector[2] == 3) { //EAST
                    vector[0]++;
                }
            } else if (command == 'L') { // turn left
                if (vector[2] == 3) { // EAST
                    vector[2] = 0; //NORTH
                } else {
                    vector[2]++;
                }
            } else if (command == 'R') { //turn rigth
                if (vector[2] == 0) { // NORTH
                    vector[2] = 3; //EAST
                } else {
                    vector[2]--;
                }    
            }
        }
        return vector[2] != 0 || (vector[0] == 0 && vector[1] == 0);
    }
}
