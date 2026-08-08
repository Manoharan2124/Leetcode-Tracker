// Last updated: 8/8/2026, 3:59:22 PM
1class Solution {
2    public int numIslands(char[][] grid) {
3        int islands = 0;
4        int rows = grid.length;
5        int cols = grid[0].length;
6        Set<String> visited = new HashSet<>();
7
8        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
9
10        for (int r = 0; r < rows; r++) {
11            for (int c = 0; c < cols; c++) {
12                if (grid[r][c] == '1' && !visited.contains(r + "," + c)) {
13                    islands++;
14                    bfs(grid, r, c, visited, directions, rows, cols);
15                }
16            }
17        }
18
19        return islands;        
20    }
21
22    private void bfs(char[][] grid, int r, int c, Set<String> visited, int[][] directions, int rows, int cols) {
23        Queue<int[]> q = new LinkedList<>();
24        visited.add(r + "," + c);
25        q.add(new int[]{r, c});
26
27        while (!q.isEmpty()) {
28            int[] point = q.poll();
29            int row = point[0], col = point[1];
30
31            for (int[] direction : directions) {
32                int nr = row + direction[0], nc = col + direction[1];
33                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == '1' && !visited.contains(nr + "," + nc)) {
34                    q.add(new int[]{nr, nc});
35                    visited.add(nr + "," + nc);
36                }
37            }
38        }
39    }    
40}