// Last updated: 7/12/2026, 7:08:28 PM
1import java.util.Arrays;
2
3class Solution {
4
5    private int recursive(int i, int j, String s, String t){
6        if(j < 0){
7            return 1;
8        }
9
10        if(i < 0){
11            return 0;
12        }
13
14        if(s.charAt(i) == t.charAt(j)){
15            return recursive(i-1, j-1, s, t) + recursive(i-1, j, s, t);
16        }
17
18        return recursive(i-1, j, s, t);
19    }
20
21    private int memoization(int i, int j, String s, String t, int[][] dp){
22        if(j == 0){
23            return 1;
24        }
25
26        if(i == 0){
27            return 0;
28        }
29
30        if(dp[i][j] != -1){
31            return dp[i][j];
32        }
33
34        if(s.charAt(i-1) == t.charAt(j-1)){
35            return dp[i][j] = memoization(i-1, j-1, s, t, dp)
36                    + memoization(i-1, j, s, t, dp);
37        }
38
39        return dp[i][j] = memoization(i-1, j, s, t, dp);
40    }
41
42    private int tabulation(String s, String t){
43
44        int n = s.length();
45        int m = t.length();
46
47        int[][] dp = new int[n+1][m+1];
48
49        for(int i = 0; i <= n; i++){
50            dp[i][0] = 1;
51        }
52
53        for(int j = 1; j <= m; j++){
54            dp[0][j] = 0;
55        }
56
57        for(int i = 1; i <= n; i++){
58            for(int j = 1; j <= m; j++){
59
60                if(s.charAt(i-1) == t.charAt(j-1)){
61                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
62                }else{
63                    dp[i][j] = dp[i-1][j];
64                }
65            }
66        }
67
68        return dp[n][m];
69    }
70
71    private int SpaceOptimized2D(String s, String t){
72
73        int n = s.length();
74        int m = t.length();
75
76        int[] prev = new int[m+1];
77        prev[0] = 1;
78
79        for(int i = 1; i <= n; i++){
80
81            int[] curr = new int[m+1];
82            curr[0] = 1;
83
84            for(int j = 1; j <= m; j++){
85
86                if(s.charAt(i-1) == t.charAt(j-1)){
87                    curr[j] = prev[j-1] + prev[j];
88                }else{
89                    curr[j] = prev[j];
90                }
91            }
92
93            prev = curr;
94        }
95
96        return prev[m];
97    }
98
99    private int SpaceOptimized1D(String s, String t){
100
101        int n = s.length();
102        int m = t.length();
103
104        int[] prev = new int[m+1];
105        prev[0] = 1;
106
107        for(int i = 1; i <= n; i++){
108            for(int j = m; j >= 1; j--){
109
110                if(s.charAt(i-1) == t.charAt(j-1)){
111                    prev[j] = prev[j-1] + prev[j];
112                }
113            }
114        }
115
116        return prev[m];
117    }
118
119    public int numDistinct(String s, String t){
120
121        int n = s.length();
122        int m = t.length();
123
124        int[][] dp = new int[n+1][m+1];
125        for(int[] row : dp){
126            Arrays.fill(row, -1);
127        }
128
129        // return recursive(n-1, m-1, s, t);
130        // return memoization(n, m, s, t, dp);
131        // return tabulation(s, t);
132        // return SpaceOptimized2D(s, t);
133        return SpaceOptimized1D(s, t);
134    }
135}