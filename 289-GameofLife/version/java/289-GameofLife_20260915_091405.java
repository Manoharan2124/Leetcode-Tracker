// Last updated: 9/15/2026, 9:14:05 AM
1class Solution {
2    public void gameOfLife(int[][] board) {
3    if (board == null || board.length == 0) return;
4    int m = board.length, n = board[0].length;
5
6    for (int i = 0; i < m; i++) {
7        for (int j = 0; j < n; j++) {
8            int lives = liveNeighbors(board, m, n, i, j);
9
10            // In the beginning, every 2nd bit is 0;
11            // So we only need to care about when will the 2nd bit become 1.
12            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
13                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
14            }
15            if (board[i][j] == 0 && lives == 3) {
16                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
17            }
18        }
19    }
20
21    for (int i = 0; i < m; i++) {
22        for (int j = 0; j < n; j++) {
23            board[i][j] >>= 1;  // Get the 2nd state.
24        }
25    }
26}
27
28public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
29    int lives = 0;
30    for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
31        for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
32            lives += board[x][y] & 1;
33        }
34    }
35    lives -= board[i][j] & 1;
36    return lives;
37}
38}