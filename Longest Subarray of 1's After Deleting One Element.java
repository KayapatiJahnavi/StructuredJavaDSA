class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, ans = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            // Shrink window if more than 1 zero
            while (zeros > 1) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            // window length - 1 (because we must delete one element)
            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}
