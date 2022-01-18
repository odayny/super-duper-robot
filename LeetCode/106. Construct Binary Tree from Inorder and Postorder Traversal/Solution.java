/**
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

 

Example 1:


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]
 

Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.
**/

/**
Build nodes recursively.
Starting from last element in postorder there will be root elements for all subtrees (root-right-left). 
At the same time the same value splits inorder into left and right subtree.
By manipulating pointers (global for postorder and local pair for inorder) it is possible to rebuild the tree.

Tricky points: non-complete nodes and end-nodes. Handled in if blocks

Space complexity: O(lg(n)) because of recursion stack may be not more than tree depth. 
Time complexity: O(n*lg(n)). N for iterating through postorder array and lg(n) for search in subarray of inorder (which is twice smaller for each node)
**/

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
    int postRootIndex;
    public TreeNode buildTree(int[] in, int[] post) {
        postRootIndex = post.length-1;
        return build(in, post, 0, in.length-1);
    }
    
    public TreeNode build(int[] in, int[] post, int inStart, int inEnd) {
        TreeNode node = new TreeNode(post[postRootIndex]);
        if (inStart == inEnd) return node;
        int inRootPos = findRootPos(post[postRootIndex], in, inStart, inEnd);
        if (inRootPos < inEnd) {
            // rigth
            postRootIndex--;
            node.right = build(in, post, inRootPos+1, inEnd);
        }
        if (inRootPos > inStart) {
            // left
            postRootIndex--;
            node.left = build(in, post, inStart, inRootPos-1);
        }
        return node;
    }
    
    public int findRootPos(int target, int[] array, int start, int end) {
        for (int i = start; i<=end; i++)
            if (array[i] == target)
                return i;
        // shoudnt reach here
        return -1;
    }
}

