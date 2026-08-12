class Solution {
    int mod = 1000000007;

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int[] row : dp) Arrays.fill(row, -1);
        
        return f(s, 0, n-1, dp);
    }

    private int f(String s, int i, int j, int[][] dp){
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != -1) return dp[i][j];
       
        long ans = 0;
        
        if(s.charAt(i) == s.charAt(j)){
            int left = i+1;
            int right = j-1;

            while(left <= right && s.charAt(left) != s.charAt(i)) left++;
            while(left <= right && s.charAt(right) != s.charAt(i)) right--;

            if(left > right) ans = 2 * f(s, i+1, j-1, dp) + 2;
            else if(left == right) ans = 2 * f(s, i+1, j-1, dp) + 1;
            else ans = 2 * f(s, i+1, j-1, dp) - f(s, left+1, right - 1, dp);
        }
        else ans = (long)f(s, i+1, j, dp) + f(s, i, j-1, dp) - f(s, i+1, j-1, dp);

        ans = (ans % mod + mod) % mod;
        return dp[i][j] = (int)ans;
    }
}