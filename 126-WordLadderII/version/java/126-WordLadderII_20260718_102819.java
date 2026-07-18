// Last updated: 7/18/2026, 10:28:19 AM
1class Solution {
2    public int minCut(String s) {
3        int n = s.length();
4        if (n <= 1) return 0;
5
6        boolean[][] isPal = new boolean[n][n];
7        // Precompute palindrome table using DP
8        for (int end = 0; end < n; end++) {
9            for (int start = 0; start <= end; start++) {
10                if (s.charAt(start) == s.charAt(end) && 
11                   (end - start <= 2 || isPal[start + 1][end - 1])) {
12                    isPal[start][end] = true;
13                }
14            }
15        }
16
17        int[] dp = new int[n];
18        for (int i = 0; i < n; i++) {
19            if (isPal[0][i]) {
20                dp[i] = 0; // No cut needed if s[0...i] is a palindrome
21            } else {
22                dp[i] = i; // Max cuts: one for each character
23                for (int j = 0; j < i; j++) {
24                    if (isPal[j + 1][i]) {
25                        // If suffix is palindrome, total = cuts for prefix + 1
26                        dp[i] = Math.min(dp[i], dp[j] + 1);
27                    }
28                }
29            }
30        }
31        return dp[n - 1];
32    }
33}