# Time Complexity :O(N+P) N is the length of prere array
# Space Complexity :O(N+P) 
# Did this code successfully run on Leetcode :yes 
# Any problem you faced while coding this :no 

# Your code here along with comments explaining your approach

# We use a Queue to perform BFS, traversing the tree level by level.
# For each level, we iterate over the current size of the queue, processing all nodes at that level.
# Children of nodes are added to the queue, and the values of each level are stored in a list.

from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        pre_map = {}
        indegree = [0] * numCourses
        queue = deque()

        for course, prereq in prerequisites:
            if prereq not in pre_map:
                pre_map[prereq] = []
            pre_map[prereq].append(course)
            indegree[course] += 1

        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)

        while queue:
            curr = queue.popleft()
            if curr in pre_map:
                for next_course in pre_map[curr]:
                    indegree[next_course] -= 1
                    if indegree[next_course] == 0:
                        queue.append(next_course)

        return all(x == 0 for x in indegree)
