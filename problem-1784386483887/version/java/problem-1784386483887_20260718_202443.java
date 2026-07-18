// Last updated: 7/18/2026, 8:24:43 PM
1class Solution {
2    public String rearrangeString(String s, char x, char y) {
3        StringBuilder otherAndY = new StringBuilder();
4        StringBuilder onlyX = new StringBuilder();
5        StringBuilder onlyY = new StringBuilder();
6        for(int i=0;i<s.length(); i++) {
7            char ch = s.charAt(i);
8            if(ch == x) {
9                onlyX.append(ch);
10            }
11            else if(ch==y) {
12                onlyY.append(ch);
13            }
14            else {
15                otherAndY.append(ch);
16            }
17        }
18        return otherAndY.append(onlyY).append(onlyX).toString();
19    }
20}