// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem

    // Complete the hasCycle function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode nodeSlow = head;
        SinglyLinkedListNode nodeFast = head.next;
        while (nodeSlow != null && nodeFast != null && nodeFast.next != null) {
            if (nodeSlow == nodeFast) {
                return true;
            }
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next.next;
        }
        return false;
    }
