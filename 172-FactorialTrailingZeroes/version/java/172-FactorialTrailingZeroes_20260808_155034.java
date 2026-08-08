// Last updated: 8/8/2026, 3:50:34 PM
1class Solution {
2    public int calculateMinimumHP(int[][] dungeon) {
3        int n = dungeon.length;
4        int m = dungeon[0].length;
5        Integer[][] dp =new Integer[n][m];
6        return memo(0,0,dungeon,dp,n,m);
7    }
8    public int memo(int r,int c,int[][] dungeon,Integer[][] dp,int n,int m){
9        if(r==n-1 && c==m-1){
10            if(dungeon[r][c]<=0){
11                return Math.abs(dungeon[r][c])+1;
12            }
13            return 1;
14        }
15        if(r>=n || c>=m){
16            return (int)1e8;
17        }
18        if(dp[r][c]!=null) return dp[r][c];
19        int down = memo(r+1,c,dungeon,dp,n,m);
20        int right = memo(r,c+1,dungeon,dp,n,m);
21        int result = Math.min(down,right) - dungeon[r][c];
22        return dp[r][c] = (result<=0)?1:result;
23    }
24}