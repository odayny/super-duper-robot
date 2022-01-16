// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode node1 = head1;
        SinglyLinkedListNode node2 = head2;
        while (true) {
            if (node1 == node2) {
                return node1.data;
            }
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == null) {
                node1 = head2;
            }
            if (node2 == null) {
                node2 = head1;
            }
        }
    }
