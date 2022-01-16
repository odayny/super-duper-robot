// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem

    // Complete the getNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        int i = positionFromTail;
        SinglyLinkedListNode result = head;
        SinglyLinkedListNode node = head;
        while (node != null) {
            if (i-- < 0) {
                result = result.next;
            }
            node = node.next;
        }
        return result.data;
    }
