class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     
        int i = m - 1;         // Pointer for nums1
        int j = n - 1;         // Pointer for nums2
        int k = m + n - 1;     // Pointer for final merged array in nums1

        // Start from the end and fill nums1 from back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has elements left, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
