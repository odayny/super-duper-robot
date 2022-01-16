// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

    // Complete the sortedInsert function below.

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
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        DoublyLinkedListNode next = head;
        DoublyLinkedListNode prev = null;
        while (true) {
            System.out.println(next == null ? null : next.data);
            if (prev == null && node.data <= next.data) {
                node.next = next;
                next.prev = node;
                return node;
            }
            if (next == null) {
                node.prev = prev;
                prev.next = node;
                return head;
            }
            if (prev != null && prev.data <= node.data && node.data <= next.data) {
                node.prev = prev;
                node.next = next;
                prev.next = node;
                next.prev = node;
                return head;
            }
            prev = next;
            next = next.next;
        }
    }
