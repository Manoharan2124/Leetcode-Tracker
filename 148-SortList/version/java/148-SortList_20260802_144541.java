// Last updated: 8/2/2026, 2:45:41 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int res = Integer.MIN_VALUE;
4        for (int n : nums) {
5            res = Math.max(res, n);
6        }
7
8        int curMax = 1, curMin = 1;
9
10        for (int n : nums) {
11            int temp = curMax * n;
12            curMax = Math.max(temp, Math.max(curMin * n, n));
13            curMin = Math.min(temp, Math.min(curMin * n, n));
14
15            res = Math.max(res, curMax);
16        }
17
18        return res;        
19    }
20}