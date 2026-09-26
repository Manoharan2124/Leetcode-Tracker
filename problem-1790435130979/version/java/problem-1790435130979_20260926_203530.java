// Last updated: 9/26/2026, 8:35:30 PM
1class Solution {
2    public int minQueenMoves(int[] source, int[] target) {
3        int sr = source[0];
4        int sc = source[1];
5        int tr = target[0];
6        int tc = target[1];
7        if(sr == tr && sc == tc) {
8            return 0;
9        }
10        if(sr == tr || sc == tc || Math.abs(sr - tr) == Math.abs(sc - tc)) {
11            return 1;
12        }
13        return 2;
14    }
15}