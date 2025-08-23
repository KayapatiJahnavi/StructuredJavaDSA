class Solution {
    public int minimumSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        // Helper to compute bounding box area inside a submatrix
        java.util.function.BiFunction<int[], int[], Integer> area = (r, c) -> {
            int minRow = r[1], maxRow = r[0];
            int minCol = c[1], maxCol = c[0];
            if (minRow > maxRow || minCol > maxCol) return 0; // no 1s
            return (maxRow - minRow + 1) * (maxCol - minCol + 1);
        };
        
        // Precompute prefix sums for fast "does this sub-rectangle have any 1s?"
        int[][] pref = new int[m+1][n+1];
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                pref[i+1][j+1] = pref[i+1][j] + pref[i][j+1] - pref[i][j] + grid[i][j];
            }
        }
        
        // function to check if submatrix [r1..r2][c1..c2] has any 1
        java.util.function.BiFunction<int[], int[], Boolean> hasOne = (r,c) -> {
            int r1=r[0], r2=r[1], c1=c[0], c2=c[1];
            if (r1>r2 || c1>c2) return false;
            int sum = pref[r2+1][c2+1] - pref[r2+1][c1] - pref[r1][c2+1] + pref[r1][c1];
            return sum>0;
        };
        
        int ans = Integer.MAX_VALUE;
        
        // Try vertical 3-way splits
        for (int c1=0;c1<n-2;c1++) {
            for (int c2=c1+1;c2<n-1;c2++) {
                // left [0..c1], mid [c1+1..c2], right [c2+1..n-1]
                int[] rows = {0,m-1};
                int area1 = boundingArea(grid, 0, m-1, 0, c1);
                int area2 = boundingArea(grid, 0, m-1, c1+1, c2);
                int area3 = boundingArea(grid, 0, m-1, c2+1, n-1);
                if (area1>=0 && area2>=0 && area3>=0)
                    ans = Math.min(ans, area1+area2+area3);
            }
        }
        
        // Try horizontal 3-way splits
        for (int r1=0;r1<m-2;r1++) {
            for (int r2=r1+1;r2<m-1;r2++) {
                // top [0..r1], mid [r1+1..r2], bottom [r2+1..m-1]
                int area1 = boundingArea(grid, 0, r1, 0, n-1);
                int area2 = boundingArea(grid, r1+1, r2, 0, n-1);
                int area3 = boundingArea(grid, r2+1, m-1, 0, n-1);
                if (area1>=0 && area2>=0 && area3>=0)
                    ans = Math.min(ans, area1+area2+area3);
            }
        }
        
        // Mixed partitions (vertical split + horizontal split inside one half)
        for (int c=0;c<n-1;c++) {
            // Left [0..c], Right [c+1..n-1]
            for (int r=0;r<m-1;r++) {
                int area1 = boundingArea(grid, 0, m-1, 0, c);
                int area2 = boundingArea(grid, 0, r, c+1, n-1);
                int area3 = boundingArea(grid, r+1, m-1, c+1, n-1);
                if (area1>=0 && area2>=0 && area3>=0)
                    ans = Math.min(ans, area1+area2+area3);
                
                area1 = boundingArea(grid, 0, m-1, c+1, n-1);
                area2 = boundingArea(grid, 0, r, 0, c);
                area3 = boundingArea(grid, r+1, m-1, 0, c);
                if (area1>=0 && area2>=0 && area3>=0)
                    ans = Math.min(ans, area1+area2+area3);
            }
        }
        
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
    
    // Helper: get minimal bounding rectangle area for 1s in submatrix
    private int boundingArea(int[][] grid, int r1, int r2, int c1, int c2) {
        int minR=r2+1, maxR=r1-1, minC=c2+1, maxC=c1-1;
        for (int i=r1;i<=r2;i++) {
            for (int j=c1;j<=c2;j++) {
                if (grid[i][j]==1) {
                    minR=Math.min(minR,i);
                    maxR=Math.max(maxR,i);
                    minC=Math.min(minC,j);
                    maxC=Math.max(maxC,j);
                }
            }
        }
        if (minR>maxR) return 0; // no 1s
        return (maxR-minR+1)*(maxC-minC+1);
    }
}
