// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem


    // Complete the reversePrint function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void reversePrint(SinglyLinkedListNode head) {
        Stack<SinglyLinkedListNode> stack = new Stack();
        SinglyLinkedListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop().data);
        }
    }
