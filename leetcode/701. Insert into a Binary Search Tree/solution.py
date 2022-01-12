# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root : return TreeNode(val)
        current = root
        while True :
            if current.val > val :
                if current.left :
                    current = current.left
                else :
                    current.left = TreeNode(val)
                    return root
            else :
                if current.right :
                    current = current.right
                else :
                    current.right = TreeNode(val)
                    return root
            
