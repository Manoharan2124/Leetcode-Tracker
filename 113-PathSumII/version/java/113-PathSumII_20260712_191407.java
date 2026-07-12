// Last updated: 7/12/2026, 7:14:07 PM
1class Solution {
2  public void solve(char[][] board) {
3    int m = board.length;
4    int n = board[0].length;
5
6    // Track the cells which are NOT part of a surrounded region (safe cells)
7    // 0 Represents Completely surrounded and 1 Represent Connected to the boundry
8    int[][] track = new int[m][n];
9
10    // Step 1: Scan top and bottom boundaries
11    for (int j = 0; j < n; j++) {
12      if (board[0][j] == 'O')
13        dfs(0, j, m, n, board, track);
14      if (board[m-1][j] == 'O')
15        dfs(m-1, j, m, n, board, track);
16    }
17
18    // Step 2: Scan left and right boundaries
19    for (int i = 0; i < m; i++) {
20      if (board[i][0] == 'O')
21        dfs(i, 0, m, n, board, track);
22      if (board[i][n-1] == 'O')
23        dfs(i, n-1, m, n, board, track);
24    }
25
26    // Step 3: Update the board based on the tracking matrix
27    for (int i = 0; i < m; i++) {
28      for (int j = 0; j < n; j++) {
29        if (track[i][j] == 0)
30          board[i][j] = 'X'; // Completely surrounded
31        else
32          board[i][j] = 'O'; // Connected to boundary, remains 'O'
33      }
34    }
35  }
36
37  private void dfs(int r, int c, int m, int n, char[][] board, int[][] track) {
38    // Base case: Out of bounds, hit an 'X', or already tracked
39    if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] == 'X' || track[r][c] == 1)
40      return;
41
42    track[r][c] = 1; // Mark as safe (not part of a surrounded region)
43
44    // Explore 4 directional neighbors
45    dfs(r-1, c, m, n, board, track); // up
46    dfs(r+1, c, m, n, board, track); // down
47    dfs(r, c-1, m, n, board, track); // left
48    dfs(r, c+1, m, n, board, track); // right
49  }
50}