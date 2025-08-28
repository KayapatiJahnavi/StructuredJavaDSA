class Solution {
    public int maxOnes(int arr[], int k) {
        int left = 0, right = 0;
        int zeros = 0, maxLen = 0;

        while (right < arr.length) {
            if (arr[right] == 0) {
                zeros++;
            }

            while (zeros > k) { // shrink window
                if (arr[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // update max length of valid window
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
