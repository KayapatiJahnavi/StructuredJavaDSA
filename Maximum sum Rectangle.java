class Solution {
    public int maxRectSum(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < m; left++) {
            int[] temp = new int[n];

            for (int right = left; right < m; right++) {
                for (int i = 0; i < n; i++) {
                    temp[i] += mat[i][right];
                }

                // Apply Kadane's algorithm on temp
                int currMax = kadane(temp);
                maxSum = Math.max(maxSum, currMax);
            }
        }

        return maxSum;
    }

    private int kadane(int[] arr) {
        int maxEndingHere = arr[0], maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
