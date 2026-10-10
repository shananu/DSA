class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        
       // image[sr][sc] = color;
        dfs(image, sr, sc, color, m, n);
        
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int m, int n){
        int iniColor = image[r][c];
        image[r][c] = color;
        
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == iniColor && image[nr][nc] != color){
                dfs(image, nr, nc, color, m, n);
            }
        }
    }
}