class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
    
        int n = fruits.length;
        int maxTotalFruits = 0;
        int left = 0, total = 0;

        // Sliding window with right pointer
        for (int right = 0; right < n; right++) {
            total += fruits[right][1];

            // Keep adjusting left pointer to stay within k steps
            while (left <= right && !withinSteps(fruits, left, right, startPos, k)) {
                total -= fruits[left][1];
                left++;
            }

            maxTotalFruits = Math.max(maxTotalFruits, total);
        }

        return maxTotalFruits;
    }

    // Helper function to check if we can reach all fruits in [left, right] within k steps
    private boolean withinSteps(int[][] fruits, int left, int right, int startPos, int k) {
        int leftPos = fruits[left][0];
        int rightPos = fruits[right][0];

        int goLeftFirst = Math.abs(startPos - leftPos) + (rightPos - leftPos);
        int goRightFirst = Math.abs(startPos - rightPos) + (rightPos - leftPos);

        return Math.min(goLeftFirst, goRightFirst) <= k;
    }
}
