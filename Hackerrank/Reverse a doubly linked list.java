// https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem

    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null) {
            return null;
        }
        DoublyLinkedListNode prev = head.prev;
        DoublyLinkedListNode node = head;
        DoublyLinkedListNode next = head.next;
        while (true) {
            node.next = prev;
            node.prev = next;
            if (next == null) {
                return node;
            }
            prev = node;
            node = node.prev;
            next = node.next;
        }

    }
