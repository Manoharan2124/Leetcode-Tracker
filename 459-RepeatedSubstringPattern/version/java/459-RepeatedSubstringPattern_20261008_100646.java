// Last updated: 10/8/2026, 10:06:46 AM
1class Solution {
2    public boolean repeatedSubstringPattern(String s) {
3        int n = s.length();
4        for (int i = 1; i <= n / 2; i++) {
5            if (n % i == 0 && s.substring(0, i).repeat(n / i).equals(s)) {
6                return true;
7            }
8        }
9        return false;
10    }
11}