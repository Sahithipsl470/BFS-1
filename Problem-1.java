// Time Complexity :O(N)
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no 

// Your code here along with comments explaining your approach
// We use a queue (deque) to perform BFS, traversing the tree level by level.
// For each level, we iterate over all nodes currently in the queue, appending their values to a list.
// Children of nodes are added to the queue, and each level’s list of values is added to the result.

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
