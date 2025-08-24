class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        int n = arr.length;
        
        // Not enough flowers
        if ((long)m * k > n) return -1;
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int day : arr) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }
        
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (canMake(arr, m, k, mid)) {
                result = mid;
                high = mid - 1; // try fewer days
            } else {
                low = mid + 1;  // need more days
            }
        }
        
        return result;
    }
    
    private boolean canMake(int[] arr, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;
        
        for (int bloom : arr) {
            if (bloom <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0; // reset streak
            }
        }
        
        return bouquets >= m;
    }
}
