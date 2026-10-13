// Last updated: 10/13/2026, 9:58:54 PM
1class Solution {
2    public boolean isSubsequence(String s, String t) {
3        int sp = 0;
4        int tp = 0;
5
6        while (sp < s.length() && tp < t.length()) {
7            if (s.charAt(sp) == t.charAt(tp)) {
8                sp++;
9            }
10            tp++;
11        }
12
13        return sp == s.length();        
14    }
15}