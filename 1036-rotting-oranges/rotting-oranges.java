class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
        return minimumCount(n,m, grid, visited);
    }

    private int minimumCount(int n, int m, int[][] grid, boolean visited[][]) {
        
        Queue<Pair<Integer, Pair<Integer, Integer>>> q = new LinkedList();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2 && !visited[i][j]) {
                   q.add(new Pair(0, new Pair(i, j)));
                   visited[i][j] = true;
                }
            }
        }

        
      int minCount = bfs(n, m, grid, visited, q);
       for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                     return -1;
                }
            }
        }
        return minCount;

    }

    private int bfs(int n, int m, int[][] grid, boolean visited[][], Queue<Pair<Integer, Pair<Integer, Integer>>> q) {
        int X[] = {0,0,-1,1};
        int Y[] = {-1,1,0,0};
        int minCount = 0; 
        while(!q.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> p = q.remove();
            int h = p.getKey();
            Pair<Integer, Integer> pairValues = p.getValue();
            int x = pairValues.getKey();
            int y = pairValues.getValue();
            // System.out.println(x + " " + y);
           
            for(int k = 0; k < 4; k++) {
                int nextX = x + X[k];
                int nextY = y + Y[k];
                if(isSafeToMove(nextX, nextY, n, m, visited, grid)) {
                    grid[nextX][nextY] = h + 1;
                    visited[nextX][nextY] = true;
                    minCount= Math.max(minCount, h + 1);
                    System.out.println(q);
                    q.add(new Pair(h + 1, new Pair(nextX, nextY)));
                }
            }
        }
        return minCount;

    }


    private boolean isSafeToMove(int i, int j, int n, int m, boolean visited[][], int grid[][]) {
        return (i >= 0 && i < n && j>=0 && j < m && !visited[i][j] && grid[i][j] == 1);
    }
}