// Last updated: 8/9/2026, 8:25:23 AM
1import java.util.ArrayList;
2import java.util.List;
3class Solution {
4    private int maxHeight = 0;
5    public long weightedSum(int[] parent, int[] nums) {
6        int n = parent.length;
7        List<List<Integer>> adj = new ArrayList<>();
8        for (int i=0;i<n;i++) {
9            adj.add(new ArrayList<>());
10        }
11        for(int i=1;i<n;i++){
12            adj.get(parent[i]).add(i);
13        }
14        int[] depths = new int[n];
15        maxHeight = 0;
16        findDepths(0, 1, adj, depths);
17        long totalWeightedSum = 0;
18        for( int i=0;i<n;i++) {
19            long weightMultiplier = (long) maxHeight - depths[i] + 1;
20            totalWeightedSum += (long) nums[i] * weightMultiplier;
21        }
22        return totalWeightedSum;
23    }
24    private void findDepths(int u, int currentDepth,List<List<Integer>> adj, int[] depths) {
25        depths[u] = currentDepth;
26        if(currentDepth > maxHeight) {
27            maxHeight = currentDepth;
28        }
29        for (int v : adj.get(u)) {
30            findDepths(v, currentDepth + 1, adj, depths);
31        }
32    }
33}