class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return -1; // Not enough books

        int low = 0, high = 0;
        for (int pages : arr) {
            low = Math.max(low, pages);  // At least one book’s pages
            high += pages;              // At most total sum
        }

        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(arr, n, k, mid)) {
                result = mid;
                high = mid - 1; // Try smaller max
            } else {
                low = mid + 1;  // Increase limit
            }
        }
        return result;
    }

    private boolean isPossible(int[] arr, int n, int k, int maxAllowed) {
        int students = 1;
        int currentSum = 0;

        for (int pages : arr) {
            if (currentSum + pages > maxAllowed) {
                students++;
                currentSum = pages;
                if (students > k) return false;
            } else {
                currentSum += pages;
            }
        }
        return true;
    }
}
