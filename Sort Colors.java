class Solution {
    public void sortColors(int[] nums) {
       
        int low = 0;        // position for 0
        int mid = 0;        // current element
        int high = nums.length - 1;  // position for 2

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap 0 to the front
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // skip 1
                mid++;
            } else {
                // nums[mid] == 2, swap with high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
