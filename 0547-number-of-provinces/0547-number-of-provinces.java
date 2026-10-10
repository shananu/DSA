class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                count++;
                dfs(isConnected, vis, i, n);
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, boolean[] vis, int i, int n){
        vis[i] = true;
        for(int j=0; j<n; j++){
            if(isConnected[i][j] == 1 && !vis[j]){
                dfs(isConnected, vis, j, n);
            }
        }
    }
}