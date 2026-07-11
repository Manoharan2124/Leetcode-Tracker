// Last updated: 7/11/2026, 8:37:32 PM
1class Solution {
2    public int numTrees(int n) {
3        int[] uniqTree = new int[n + 1];
4        for (int i = 0; i <= n; i++) {
5            uniqTree[i] = 1;
6        }
7
8        for (int nodes = 2; nodes <= n; nodes++) {
9            int total = 0;
10            for (int root = 1; root <= nodes; root++) {
11                total += uniqTree[root - 1] * uniqTree[nodes - root];
12            }
13            uniqTree[nodes] = total;
14        }
15
16        return uniqTree[n];        
17    }
18}