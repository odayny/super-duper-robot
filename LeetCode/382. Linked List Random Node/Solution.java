/*
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

Solution(ListNode head) Initializes the object with the integer array nums.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be choosen.
 

Example 1:


Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 

Constraints:

The number of nodes in the linked list will be in the range [1, 104].
-104 <= Node.val <= 104
At most 104 calls will be made to getRandom.
 

Follow up:

What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// First idea
// class Solution {
//     int size = 10000;
//     int pos = 0;
//     ListNode head;
//     ListNode current;
//     Random rnd = new Random();
//     public Solution(ListNode head) {
//         this.head = head;
//         current = head;
//     }
    
//     public int getRandom() {
//         int next = rnd.nextInt(size);
//         while (next>0) {
//             next--;
//             pos++;
//             current = current.next;
//             if (current == null) {
//                 size = pos;
//                 pos = 0;
//                 current = head;
//             }
//         }
//         return current.val;
//     }
// }

// Reservoir Sampling
// class Solution {
//     ListNode head;
//     Random rnd = new Random();
//     public Solution(ListNode head) {
//         this.head = head;
//     }
    
//     public int getRandom() {
//         int result = 0;
//         ListNode current = head;
//         int scope = 1;
//         while (current !=null) {
//             if (rnd.nextDouble() < 1.0 / scope++) {
//                 result = current.val;
//             }
//             current = current.next;
//         }
//         return result;
//     }
// }

class Solution {
    Random rnd = new Random();
    int size = rnd.nextInt(10000);
    ListNode head;
    ListNode current;
    
    public Solution(ListNode head) {
        this.head = head;
        current = head;
    }
    
    public int getRandom() {
        int next = rnd.nextInt(size);
        int pos = 0;
        while (next-->0) {
            pos++;
            if (current.next == null) {
                size = pos;
                current.next = head;
            }
            current = current.next;
        }
        return current.val;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
