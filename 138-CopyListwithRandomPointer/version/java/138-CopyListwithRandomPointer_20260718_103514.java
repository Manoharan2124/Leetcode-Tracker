// Last updated: 7/18/2026, 10:35:14 AM
1public class Solution {
2    public int hammingWeight(int n) {
3        int count = 0;
4
5        while (n != 0) {
6            if ((n & 1) == 1) {
7                count++;
8            }
9            n >>>= 1;
10        }
11        return count;
12    }
13}