class Solution {
    public int median(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Find min and max in matrix
        for (int i = 0; i < n; i++) {
            min = Math.min(min, mat[i][0]);       // first element of row
            max = Math.max(max, mat[i][m - 1]);   // last element of row
        }

        int desired = (n * m + 1) / 2; // index of median

        while (min < max) {
            int mid = min + (max - min) / 2;

            // Count how many elements <= mid
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmallerEqual(mat[i], mid);
            }

            if (count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    // Binary search in a row
    private int countSmallerEqual(int[] row, int x) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (row[mid] <= x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l; // number of elements <= x
    }
}
