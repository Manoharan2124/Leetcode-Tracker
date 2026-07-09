// Last updated: 7/9/2026, 3:19:13 PM
class Solution {

    int count = 0;
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;

    public int totalNQueens(int n) {

        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];

        backtrack(0, n);

        return count;
    }

    private void backtrack(int row, int n) {

        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2])
                continue;

            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n);

            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}