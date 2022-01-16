// https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/


    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = head;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (node == null) {
            return newNode;
        }
        while (true) {
            if (node.next == null) {
                node.next = newNode;
                return head;
            }
            node = node.next;
        }

    }
