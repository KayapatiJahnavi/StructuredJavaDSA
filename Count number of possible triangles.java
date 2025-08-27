class Solution {
    public int countTriangles(int arr[]) {
        int n = arr.length;
        Arrays.sort(arr); // Step 1: sort
        int count = 0;

        // Step 2: Fix the largest side one by one
        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;

            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    // all elements from i..j-1 with arr[j] are valid
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    
}
