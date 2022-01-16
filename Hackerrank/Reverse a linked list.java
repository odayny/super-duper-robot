// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem


    // Complete the reverse function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        Stack<SinglyLinkedListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        SinglyLinkedListNode result = null;
        while (!stack.empty()) {
            if (result == null) {
                result = new SinglyLinkedListNode(stack.pop().data);
                node = result;
            } else {
                node.next = new SinglyLinkedListNode(stack.pop().data);
                node = node.next;
            }
        }
        return result;
    }
