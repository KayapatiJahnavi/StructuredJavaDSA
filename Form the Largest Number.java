class Solution {
    public String findLargest(int[] arr) {
        // code here
        
        // Convert int[] to String[]
        String[] nums = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = String.valueOf(arr[i]);
        }

        // Custom sort: compare concatenations
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // If the largest is "0", all are zeros
        if (nums[0].equals("0")) {
            return "0";
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }
}
