class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        // for(int i=0; i<n; i++) dp[i][0] = i;
        // for(int j=0; j<m; j++) dp[0][j] = j;

        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }

        return f(word1, word2, dp, n, m);
    }

    private int f(String word1, String word2, int[][] dp, int i, int j){
        if(i == 0) return j;
        if(j == 0) return i;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = f(word1, word2, dp, i-1, j-1);
        else{
            int delete = f(word1, word2, dp, i-1, j);
            int insert = f(word1, word2, dp, i, j-1);
            int convert = f(word1, word2, dp, i-1, j-1);
            dp[i][j] = 1 + Math.min(delete, Math.min(insert, convert));
        }        

        return dp[i][j];
    }
}