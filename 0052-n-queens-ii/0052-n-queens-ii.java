class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        int res = dfs(0, board);
        return res;
    }

    private int dfs(int col, char[][] board){
        if(col == board.length){
            return 1;
        }

        int count = 0;

        for(int row=0; row<board.length; row++){
            if(validate(board, row, col)){
                board[row][col] = 'Q';
                count += dfs(col+1, board);
                board[row][col] = '.';
            }
        }

        return count;
    }

    private boolean validate(char[][] board, int row, int col){
        int r = row, c = col;
        //left diagonal up
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q') return false;
            r--;
            c--;
        }
        //left same row
        r = row; c = col;
        while(c >= 0){
            if(board[r][c] == 'Q') return false;
            c--;
        }
        //left diagonal down
        r = row; c = col;
        while(r < board.length && c >= 0){
            if(board[r][c] == 'Q') return false;
            c--;
            r++;
        }
        return true;
    }
}