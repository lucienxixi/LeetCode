```
// 出现问题，TLE，需要重写
class Solution {
    boolean result;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        
        result = false;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                dfs(board, word, j, i, board[i][j] + "", dx, dy, visited);
                visited[i][j] = false;
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, 
                     String word,
                     int x,
                     int y,
                     String curWord,
                     int[] dx,
                     int[] dy,
                     boolean[][] visited) {
        
        // System.out.println(curWord);
        if (word.equals(curWord)) {
            result = true;
            return;
        }
        
        // if (word.length() == curWord.length()) {
        //     return;
        // }
        
        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            
            if (x1 < 0 || y1 < 0 || x1 == board[0].length || y1 == board.length) {
                continue;
            }
            
            if (visited[y1][x1]) {
                continue;
            }
            
            if (curWord.length() == word.length()) {
                continue;
            }
            
            visited[y1][x1] = true;
            dfs(board, word, x1, y1, curWord + board[y1][x1], dx, dy, visited);
            visited[y1][x1] = false;
        }
        
    }
}
```