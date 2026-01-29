# Time Complexity :O(N)
# Space Complexity :O(N) 
# Did this code successfully run on Leetcode :yes 
# Any problem you faced while coding this :no 

# Your code here along with comments explaining your approach
# We use a queue (deque) to perform BFS, traversing the tree level by level.
# For each level, we iterate over all nodes currently in the queue, appending their values to a list.
# Children of nodes are added to the queue, and each level’s list of values is added to the result.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        stack = deque()
        res = []
        if root != None:
            stack.append(root)
        while stack:
            n = len(stack)
            out = []
            for i in range(n):
                node = stack.popleft()
                out.append(node.val)
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)
            res.append(out)
        return res
        

        
        