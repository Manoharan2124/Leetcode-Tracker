// Last updated: 8/8/2026, 3:49:48 PM
1class Solution {
2    public int trailingZeroes(int n) {
3        int ans = 0;
4
5        while (n > 0) {
6            n /= 5;
7            ans += n;
8        }
9
10        return ans;
11    }
12}