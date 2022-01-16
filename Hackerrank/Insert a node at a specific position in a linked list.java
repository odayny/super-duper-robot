// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem


    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode node = head;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        int current = 0;
        while (true) {
            if (position == current++) {
                newNode.next = node;
                if (prev == null) {
                    return newNode;
                } else {
                    prev.next=newNode;
                    return head;
                }
            }
            prev = node;
            node = node.next;
        }

    }
