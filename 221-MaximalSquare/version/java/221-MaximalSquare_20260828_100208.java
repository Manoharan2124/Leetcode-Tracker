// Last updated: 8/28/2026, 10:02:08 AM
1class Solution {
2    public int maximalSquare(char[][] matrix) {
3        if (matrix.length == 0 || matrix[0].length == 0) {
4            return 0;
5        }
6        
7        int rows = matrix.length;
8        int cols = matrix[0].length;
9        int[][] dp = new int[rows][cols];
10        int maxSide = 0;
11        
12        for (int i = 0; i < rows; i++) {
13            for (int j = 0; j < cols; j++) {
14                if (matrix[i][j] == '1') {
15                    if (i == 0 || j == 0) {
16                        dp[i][j] = 1;
17                    } else {
18                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
19                    }
20                    maxSide = Math.max(maxSide, dp[i][j]);
21                }
22            }
23        }
24        
25        return maxSide * maxSide;
26    }
27}