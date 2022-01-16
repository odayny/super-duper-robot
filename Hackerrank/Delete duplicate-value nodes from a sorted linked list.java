// https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem

    // Complete the removeDuplicates function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode prev = head;
        SinglyLinkedListNode node = head;
        while (node != null) {
            if (prev.data != node.data) {
                prev.next = node;
                prev = prev.next;
            }
            node = node.next;
        }
        prev.next = null;
        return head;
    }
