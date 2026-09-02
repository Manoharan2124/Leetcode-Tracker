// Last updated: 9/2/2026, 9:03:17 AM
1class Solution {
2    public boolean isPowerOfTwo(int n) {
3        return n> 0 && (n & (n-1)) == 0;
4    }
5}