/*
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
 

Constraints:

1 <= trips.length <= 1000
trips[i].length == 3
1 <= numPassengersi <= 100
0 <= fromi < toi <= 1000
1 <= capacity <= 105
*/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
        //straithforward sloution
        int[] stops = new int[1001];
        for (int[] trip : trips) {
            for (int i = trip[1]; i < trip[2]; i++) {
                stops[i] += trip[0];
                if (stops[i] > capacity) {
                    return false;
                }
            }
        }
        return true;
        //time O(N*(avg(to)-avg(from))
        //space O(1)
        */
        
        
        //a bit cleaner
        int[] stops = new int[1001];
        for (int[] trip : trips) {
            stops[trip[1]] += trip[0];
            stops[trip[2]] -= trip[0];
        }
        for (int stop : stops) {
            capacity -= stop;
            if (capacity < 0) return false;
        }
        return true;
    }
}

/*
These solutions are good just because "0 <= fromi < toi <= 1000"
Another solution is to play with sorting and priority queues
*/
