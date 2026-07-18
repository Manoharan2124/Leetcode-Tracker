// Last updated: 7/18/2026, 8:26:54 PM
1class Solution {
2    public long maximumValue(int n, int s, int m) {
3        if(n==1) {
4            return s;
5        }
6        long maxVal = (long) s +m;
7        long pairs = (n-2)/2;
8        maxVal += pairs * (m-1);
9        return maxVal;
10    }
11}