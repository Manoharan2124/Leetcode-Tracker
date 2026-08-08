// Last updated: 8/8/2026, 4:00:33 PM
1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        List<List<Integer>> adj = new ArrayList<>();
4        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
5
6        for (int[] pre : prerequisites)
7            adj.get(pre[1]).add(pre[0]);
8
9        boolean[] vis = new boolean[numCourses];
10        boolean[] path = new boolean[numCourses];
11
12        for (int i = 0; i < numCourses; i++)
13            if (!vis[i] && dfs(i, adj, vis, path)) return false;
14
15        return true;
16    }
17
18    private boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path) {
19        vis[node] = path[node] = true;
20
21        for (int next : adj.get(node))
22            if (!vis[next] && dfs(next, adj, vis, path)) return true;
23            else if (path[next]) return true;
24            
25        path[node] = false;
26        return false;
27    }
28}