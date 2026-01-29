// Time Complexity :O(N+P) N is the length of prere array
// Space Complexity :O(N+P) 
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no 

// Your code here along with comments explaining your approach

// We use a Queue to perform BFS, traversing the tree level by level.
// For each level, we iterate over the current size of the queue, processing all nodes at that level.
// Children of nodes are added to the queue, and the values of each level are stored in a list.

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list: prereq -> list of courses depending on it
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // indegree array: number of prerequisites for each course
        int[] indegree = new int[numCourses];

        // build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        // queue of courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // BFS topological sort
        int visited = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited++;

            for (int next : adj.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // if we visited all courses, no cycle exists
        return visited == numCourses;
    }
}
