class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        int maxDiagSquared = 0;

        for (int[] rect : dimensions) {
            int length = rect[0];
            int width = rect[1];

            int diagSquared = length * length + width * width;
            int area = length * width;

            if (diagSquared > maxDiagSquared) {
                maxDiagSquared = diagSquared;
                maxArea = area;
            } else if (diagSquared == maxDiagSquared) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    
}
