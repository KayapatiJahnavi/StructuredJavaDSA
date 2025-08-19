class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;   // total subarrays
        long curr = 0;    // current consecutive zeros

        for (int num : nums) {
            if (num == 0) {
                curr++;         // extend current zero streak
                count += curr;  // add all subarrays ending here
            } else {
                curr = 0;       // reset streak
            }
        }
        return count;
    }
}
