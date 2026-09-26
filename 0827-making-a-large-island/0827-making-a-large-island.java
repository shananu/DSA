class Solution {
    int n;
    int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        n = grid.length;

        HashMap<Integer, Integer> sizeMap = new HashMap<>();
        int islandId = 2;
        int maxSize = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j] == 1){
                    int size = dfs(grid, i, j, islandId);

                    sizeMap.put(islandId, size);
                    maxSize = Math.max(maxSize, size);
                    islandId++;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j] == 0){
                    
                    Set<Integer> islands = new HashSet<>();
                    for(int[] d : dir){
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if(ni >= 0 && nj >= 0 && ni < n && nj < n && grid[ni][nj] > 1){
                            islands.add(grid[ni][nj]);
                        }

                        int curSize = 1;

                        for(int id : islands){
                            curSize += sizeMap.get(id);
                        }

                        maxSize = Math.max(curSize, maxSize);
                    }
                }
            }
        } 

        return maxSize;       
    }

    private int dfs(int[][] grid, int i, int j, int islandId){
        if(i < 0 || i >= n || j < 0 || j >=n){
            return 0;
        }

        if(grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = islandId;
        int size = 1;

        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];

            size += dfs(grid, ni, nj, islandId);
        }

        return size;
    }
}