"""
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

The number of nodes in each tree is in the range [0, 5000].
-105 <= Node.val <= 105
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        """
        To traverce a tree in ascending order we have to process a tree in inorder...
        Can we do this with a queue or stack?
        
        Let's take the trees from an example:
        
         2      1
        1 4    0 3
        
        If I put both roots in a dequeue(s)...
        
        Nah...
        But one of aproaches is a queue prep with a recursion...
        
        so lets do it this way: iterate thouhg bot trees -> get two ascending list -> merge them in one
        """
        list1 = self.iterate(root1)
        list2 = self.iterate(root2)
        return self.merge(list1, list2)
    
    def iterate(self, root : TreeNode) -> List[int] :
        if not root :
            return []
        return self.iterate(root.left) + [root.val] + self.iterate(root.right)
    
    def merge(self, list1 : List[int], list2 : List[int]) -> List[int] :
        res = []
        n1 = len(list1)
        n2 = len(list2)
        i1 = 0
        i2 = 0
        while i1 < n1 or i2 < n2 :
            if i1 < n1 and i2 < n2 :
                if list1[i1] < list2[i2] :
                    res.append(list1[i1])
                    i1 += 1
                else :
                    res.append(list2[i2])
                    i2 += 1
            if i1 >= n1 :
                return res + list2[i2:n2]
            if i2 >= n2 :
                return res + list1[i1:n1]
        return res
