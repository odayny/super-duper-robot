/*
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

 

Example 1:


Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: seats = [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Example 3:

Input: seats = [0,1]
Output: 1
 

Constraints:

2 <= seats.length <= 2 * 104
seats[i] is 0 or 1.
At least one seat is empty.
At least one seat is occupied.*/
class Solution {
    public int maxDistToClosest_o2n(int[] seats) {
        int n = seats.length;
        //O(2n) hangover solution
        /*
        [0,0,0,0,1] -> [0,0,0,0,1] -> [5,4,3,2,1] -> return max-1 (4)
        [1,0,0,0,1,0,1] -> [1,2,3,4,1,2,1] -> [1,2,3,2,1,2,1] -> return max-1 (2)
        [1,0,0,0] -> [1,2,3,4] -> [1,2,3,4] -> return max-1 (3)
        */
        int counter = 1;
        boolean count = false;
        // left to right
        for (int i = 0; i < n; i++) {
            if (count && seats[i] == 0) {
                seats[i] = ++counter;
            } else if (seats[i] == 1) {
                counter = 1;
                count = true;
            }
        }
        counter = 1;
        count = false;
        int max = 0;
        // right to left and find max
        for (int i = n-1; i >= 0; i--) {
            if (count && seats[i] != 1) {
                if (seats[i] == 0) {
                    seats[i] = ++counter;
                } else {
                    seats[i] = Math.min(seats[i], ++counter);
                }
            } else if (seats[i] == 1) {
                counter = 1;
                count = true;
            }
            max = Math.max(seats[i], max);
        }
        return max - 1;
    }
    
    
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        //O(n) hangover solution
        /*
        [0,0,0,0,1] -> 4 zeroes from begginning till 1 -> 0 zeroes from 1 till end-> return 4
        [1,0,0,0,1,0,1] -> 0 zeroes from begginning till 1 -> 3 zeroes from 1 to 1 -> 3/2 = 1 + 3%2 = 2 -> 1 zero from 1 to 1 -> 1/2 = 0 + 1%2 = 1 -> 0 zeroes from 1 till end -> return 2
        [1,0,0,0] -> 0 zeroes from begginning till 1 -> 3 zeroes from 1 till end -> return 3
        [1,0,0,1] -> 2/2 + 2%2 = 2
        */
        int prev = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    max = i;
                } else {
                    int dist = i - prev - 1;
                    max = Math.max(max, dist / 2 + dist % 2);
                }
                prev = i;
            }
        }
        max = Math.max(max, n - prev - 1);
        return max;
    }
}
