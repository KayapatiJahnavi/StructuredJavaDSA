class Solution {
    public int minCapability(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canRob(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canRob(int[] nums, int k, int capability) {
        int stolenCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                stolenCount++;
                i++;
            }
            if (stolenCount >= k) {
                return true;
            }
        }
        return stolenCount >= k;
    }
}
    
