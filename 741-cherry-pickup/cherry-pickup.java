class Solution {
    int[][] moves = {{-1, 0}, {0, -1}};
    Integer[][][][] dp;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new Integer[n][n][n][n];

        return Math.max(0, helper(grid, n - 1, n - 1, n - 1, n - 1));
    }

    private int helper(int[][] grid, int i1, int j1, int i2,  int j2){
        if(i1 < 0 || i2 < 0 || j1 < 0 || j2 < 0) return -1;
        if(i1 == 0 && j1 == 0 && i2 == 0 && j2 == 0){
            return grid[0][0];
        }

        if(grid[i1][j1] == -1 || grid[i2][j2] == -1){
            return -1;
        }

        if(dp[i1][j1][i2][j2] != null) return dp[i1][j1][i2][j2];

        int curr = (i1 == i2 && j1 == j2) ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2];

        int max = -1;
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                max = Math.max(max, helper(grid, i1 + moves[i][0], j1 + moves[i][1], i2 + moves[j][0], j2 + moves[j][1]));
            }
        }

        dp[i1][j1][i2][j2] = (max == -1) ? max : curr + max;

        return dp[i1][j1][i2][j2];
    }
}