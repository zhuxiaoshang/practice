package leetcode;

/**
 * 岛屿数量
 */
public class NumIslands {
    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int island = 0;
        boolean[][] visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visit[i][j]&&grid[i][j]=='1') {
                    island++;
                    dfs(grid, i, j, row, col, visit);
                }
            }
        }
        return island;
    }

    public  void dfs(char[][] grid, int r, int c, int rowLength, int colLength, boolean[][] visit) {
        if (r < 0 || r >= rowLength || c < 0 || c >= colLength || grid[r][c] == '0') {
            return;
        }
        visit[r][c] = true;
        dfs(grid, r - 1, c, rowLength, colLength, visit);
        dfs(grid, r, c - 1, rowLength, colLength, visit);
        dfs(grid, r + 1, c, rowLength, colLength, visit);
        dfs(grid, r, c + 1, rowLength, colLength, visit);
    }

}
