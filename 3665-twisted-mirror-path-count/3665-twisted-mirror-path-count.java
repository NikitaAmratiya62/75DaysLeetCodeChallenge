class Solution {
    int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[m * n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (dp[index] == 0) continue;
                int[] right = getNext(grid, i, j, 0);
                if (right != null) {
                    int nextIndex = right[0] * n + right[1];
                    dp[nextIndex] = (int)(
                        (dp[nextIndex] + (long) dp[index]) % MOD
                    );
                }
                int[] down = getNext(grid, i, j, 1);
                if (down != null) {
                    int nextIndex = down[0] * n + down[1];
                    dp[nextIndex] = (int)(
                        (dp[nextIndex] + (long) dp[index]) % MOD
                    );
                }
            }
        }
        return dp[m * n - 1];
    }
    int[] getNext(int[][] grid, int i, int j, int dir) {
        int m = grid.length;
        int n = grid[0].length;
        while (true) {
            if (dir == 0)
                j++;
            else
                i++;
            if (i >= m || j >= n)
                return null;
            if (grid[i][j] == 0)
                return new int[]{i, j};
            // Mirror reflection
            if (dir == 0)
                dir = 1;
            else
                dir = 0;
        }
    }
}