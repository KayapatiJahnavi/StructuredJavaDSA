class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int l = 0, sum = 0, maxSums = 0;

        for (int r = 0; r < nums.length; r++) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            sum += nums[r];
            maxSums = Math.max(maxSums, sum);
        }
        return maxSums;
    }
}
