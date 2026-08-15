// Last updated: 8/15/2026, 8:38:55 PM
1class Solution {
2    public int minOperations(String s) {
3        int n = s.length();
4        int minTotalOps = Integer.MAX_VALUE;
5        for (int k=0;k<n;k++) {
6            String rotated = s.substring(k) + s.substring(0, k);
7            int incrementOps = 0;
8            int left = 0;
9            int right = n-1;
10            while (left < right) {
11                char c1 = rotated.charAt(left);
12                char c2 = rotated.charAt(right);
13                if(c1 != c2) {
14                    int diff1 = (c2 - c1 + 26) % 26;
15                    int diff2 = (c1 - c2 + 26) % 26;
16                    incrementOps += Math.min(diff1, diff2);
17                }
18                left++;
19                right--;
20            }
21            minTotalOps = Math.min(minTotalOps, k + incrementOps);
22        }
23        return minTotalOps;
24    }
25}