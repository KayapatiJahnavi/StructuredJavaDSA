class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] heights = new int[m][n];

        // Build heights matrix (number of consecutive 1's vertically)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[i][j] = (i > 0 ? heights[i - 1][j] : 0) + 1;
                }
            }
        }

        int ans = 0;
        // For each row, calculate submatrices ending at each column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (heights[i][j] > 0) {
                    int minHeight = heights[i][j];
                    for (int k = j; k >= 0; k--) {
                        if (heights[i][k] == 0) break;
                        minHeight = Math.min(minHeight, heights[i][k]);
                        ans += minHeight;
                    }
                }
            }
        }

        return ans;
    }
}
  
