// Last updated: 9/26/2026, 8:38:12 PM
1class Solution {
2    public boolean canTransform(int[] source, int[] target) {
3        if(source.length != target.length) {
4            return false;
5        }
6        long sumSource = 0;
7        long sumTarget = 0;
8        for(int i=0;i<source.length;i++) {
9            sumSource += source[i];
10            sumTarget += target[i];
11        }
12        return sumSource == sumTarget;
13    }
14}