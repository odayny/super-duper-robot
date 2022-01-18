/*
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 

Constraints:

1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108
*/
class Solution {
    public int minJumps_failed(int[] arr) {
        int n = arr.length;
        int[] steps = new int[n];
        
        //init
        for (int i = n-1; i >= 0; i--) {
            steps[i] = n - i - 1;
        }
        
        //main work here  
        for (int i = n-1; i >= 0; i--) { 

            //find same values
            for (int j = 0; j < n; j++) {
                if (arr[j] != arr[i] || i == j) {
                    continue;
                } 
                
                //modify steps
                //right
                int newSteps = steps[i];
                for (int k = j; k < n; k++) {
                    newSteps++;
                    if (steps[k] < newSteps) {
                        break;
                    } else {
                        steps[k] = newSteps;
                    }
                }
                //left
                newSteps = steps[i];
                for (int k = j; k >= 0; k--) {
                    newSteps++;
                    if (steps[k] < newSteps) {
                        break;
                    } else {
                        steps[k] = newSteps;
                    }
                }
            }
        }        
        
        
        return steps[0];
        
    }
    
    
    public int minJumps(int[] arr) {
        int n = arr.length;
        //graph scturcture : value -> all indexes
        Map<Integer, List<Integer>> dictionary = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dictionary.computeIfAbsent(arr[i], k -> new LinkedList<>()).add(i);  
        }
        
        int i = 0;
        Set<Integer> visitedNodes = new HashSet<>();
        List<Integer> nextSteps = new LinkedList<>();
        nextSteps.add(0);
        while (!nextSteps.isEmpty()) {
            List<Integer> newNextSteps = new LinkedList<>();
            for (Integer idx : nextSteps) {
                if (idx == n-1) {
                    return i;
                }
                visitedNodes.add(idx);
                //neighbors
                if (idx - 1 >= 0 && !visitedNodes.contains(idx - 1)) {
                    newNextSteps.add(idx - 1);
                }
                if (idx + 1 < n && !visitedNodes.contains(idx + 1)) {
                    newNextSteps.add(idx + 1);
                }
                //same values
                for (Integer sameNodeIdx : dictionary.get(arr[idx])) {
                    if (!visitedNodes.contains(sameNodeIdx)) {
                       newNextSteps.add(sameNodeIdx);
                    }
                }
                //very imprortant thing to speed up shit
                dictionary.get(arr[idx]).clear();
            }
            nextSteps = newNextSteps;
            i++;
        }
        return i;
    }

}
