public class SerializeTest {
    /*
               1
         /          \
        2            3
     /    \        /   \
    4      5      6     7
   / \    /  \   / \   / \
  x   9  10  11 x   x 12  x
   */
    static TreeNode test;
    static {
        TreeNode n12 = new TreeNode(12);
        TreeNode n11 = new TreeNode(11);
        TreeNode n10 = new TreeNode(10);
        TreeNode n9 = new TreeNode(9);

        TreeNode n7 = new TreeNode(7, null, n12);
        TreeNode n6 = new TreeNode(6);
        TreeNode n5 = new TreeNode(5, n11, n10);
        TreeNode n4 = new TreeNode(4, n9, null);

        TreeNode n3 = new TreeNode(3, n7, n6);
        TreeNode n2 = new TreeNode(2, n5, n4);

        test = new TreeNode(1, n3, n2);
    }

    public static void main(String[] args) {
        System.out.println(new Codec().serialize(test));
        System.out.println(new Codec().serialize(new TreeNode(1)));
    }
}