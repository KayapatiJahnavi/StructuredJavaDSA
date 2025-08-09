class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int c : candies) sum += c;

        // If total candies are less than children, impossible to give at least 1 candy each
        if (sum < k) return 0;

        int low = 1;  // <-- Start from 1, not 0
        int high = (int) 1e7; // Or max pile value
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAllocate(candies, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canAllocate(int[] candies, long k, int perChild) {
        long count = 0;
        for (int c : candies) {
            count += c / perChild;
            if (count >= k) return true;
        }
        return count >= k;
    }
}

