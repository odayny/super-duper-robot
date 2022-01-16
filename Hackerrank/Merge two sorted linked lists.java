// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;
        SinglyLinkedListNode result = null;
        SinglyLinkedListNode prev = null;
        while (node1 != null && node2 != null) {
            SinglyLinkedListNode node = null;
            if (node1.data >= node2.data) {
                node = node2;
                node2 = node2.next;
            } else {
                node = node1;
                node1 = node1.next;
            }
            if (result == null) {
                result = node;
                prev = node;
            } else {
                prev.next = node;
                prev = prev.next;
            }
        }
        if (node1 != null) {
            prev.next = node1;
        }
        if (node2 != null) {
            prev.next = node2;
        }
        return result;
    }
