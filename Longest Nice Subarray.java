class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int currentOR = 0;

        for (int right = 0; right < nums.length; right++) {
            while ((currentOR & nums[right]) != 0) {
                currentOR ^= nums[left];
                left++;
            }
            currentOR |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
