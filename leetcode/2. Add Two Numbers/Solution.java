/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
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
class Solution {
    public ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
        int acc = 0;
        ListNode result = null;
        ListNode pr = null; 
        ListNode p1 = l1; 
        ListNode p2 = l2;
        while (p1 != null || p2 != null || acc > 0) {
            if (p1 != null) {
                acc += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                acc += p2.val;
                p2 = p2.next;
            }
            ListNode curr = new ListNode(acc % 10);
            acc /= 10;
            if (result == null) {
                result = curr;
            }
            if (pr == null) {
                pr = curr;
            } else {
                pr.next = curr;
                pr = curr;
            }
        }  
        return result;
    }
    
    //save some memory and stop process earlier if possible
    //до пизди ця ваша оптимізація)))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int acc = 0;
        ListNode curr1 = l1; 
        ListNode curr2 = l2;
        while (curr1 != null && curr2 != null) {
            acc += curr1.val;
            acc += curr2.val;
            
            int res = acc > 9 ? acc - 10 : acc;
            acc /= 10;
            
            //where to write? l1 or l2? BOTH!
            curr1.val = res;
            curr2.val = res;
            
            //if one of list about to end be ready to return another
            if (curr1.next == null) {
                //no more operations 
                while (acc != 0) {
                    if (curr2.next != null) {
                        acc += curr2.next.val;
                        curr2.next.val = acc > 9 ? acc - 10 : acc;
                        acc /= 10;
                        curr2 = curr2.next;
                    } else {
                        curr2.next = new ListNode(acc);
                        acc = 0;
                    }
                }                    
                return l2;

            }
            if (curr2.next == null) {
                while (acc != 0) {
                    if (curr1.next != null) {
                        acc += curr1.next.val;
                        curr1.next.val = acc > 9 ? acc - 10 : acc;
                        acc /= 10;
                        curr1 = curr1.next;
                    } else {
                        curr1.next = new ListNode(acc);
                        acc = 0;
                    }
                }                    
                return l1;
            }
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }  
        return l1;
    }
}
