// Last updated: 8/1/2026, 8:13:59 PM
1class Solution {
2    public int countValidPrefixes(String s) {
3        int count0 = 0;
4        int count1 = 0;
5        int validPrefixes = 0;
6        for(int i=0;i<s.length();i++){
7            if(s.charAt(i) == '0') {
8                count0++;
9            }else {
10                count1++;
11            }
12            if(Math.abs(count0 - count1) <=1) {
13                validPrefixes++;
14            }
15        }
16        return validPrefixes;
17    }
18}