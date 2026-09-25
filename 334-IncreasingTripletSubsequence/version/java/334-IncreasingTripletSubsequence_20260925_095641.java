// Last updated: 9/25/2026, 9:56:41 AM
1class Solution {
2    public boolean increasingTriplet(int[] nums) {
3       int min1 = Integer.MAX_VALUE;
4       int min2 = Integer.MAX_VALUE;
5       for(int n : nums) {
6           if(n <= min1) min1 = n;
7           else if(n <= min2) min2 = n;
8           else return true;
9       }
10       return false;
11    }
12}