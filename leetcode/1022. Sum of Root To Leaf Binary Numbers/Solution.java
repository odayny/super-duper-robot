/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return sum(root, 0);
    }
    int sum(TreeNode node, int sum){
 if (node.right == null && node.left == null) return sum*2+node.val;
        int res =0;
        if (node.left != null) res+= sum(node.left, sum*2+node.val);
        if (node.right != null) res+= sum(node.right, sum*2+node.val);
        return res;
}
}
