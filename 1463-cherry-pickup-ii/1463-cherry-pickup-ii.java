class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b, -1);
            }
        }
        
        return f(grid, 0, 0, m-1, n, m, dp);
    }

    private int f(int[][] grid, int i, int j1, int j2, int n, int m, int[][][] dp){
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return (int)-1e8;
        if(i == n-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int temp = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        int max = Integer.MIN_VALUE;
        
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                int ans = temp + f(grid, i+1, j1+dj1, j2+dj2, n, m, dp);
                max = Math.max(max, ans);
            }
        }

        return dp[i][j1][j2] = max;
    }
}