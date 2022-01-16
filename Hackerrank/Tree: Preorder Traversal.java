//https://www.hackerrank.com/challenges/tree-preorder-traversal/problem


/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void preOrder(Node root) {
        Stack<Node> treeStack = new Stack<>();
        treeStack.push(root);
        while (!treeStack.empty()) {
            Node node = treeStack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                treeStack.push(node.right);
            }
            if (node.left != null) {
                treeStack.push(node.left);
            }
        }
    }

