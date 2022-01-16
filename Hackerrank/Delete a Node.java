// https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem


    // Complete the deleteNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode node = head;
        int current = 0;
        while(true) {
            if (position == current++) {
                if (prev == null) {
                    return node.next;
                } else {
                    prev.next = node.next;
                    return head;
                }
            }
            prev = node;
            node = node.next;
        }

    }
