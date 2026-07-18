// Last updated: 7/18/2026, 10:31:41 AM
1class Solution {
2    public boolean wordBreak(String s, List<String> wordDict) {
3        boolean[] dp = new boolean[s.length() + 1];
4        dp[0] = true;
5
6        for (int i = 1; i <= s.length(); i++) {
7            for (String w : wordDict) {
8                int start = i - w.length();
9                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
10                    dp[i] = true;
11                    break;
12                }
13            }
14        }
15        return dp[s.length()];        
16    }
17}