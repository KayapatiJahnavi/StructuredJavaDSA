import java.util.*;

class Solution {
    public void rearrange(int[] arr, int x) {
        // Convert to Integer[] to use custom comparator
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Stable sort by absolute difference
        Arrays.sort(boxed, (a, b) -> {
            int diff1 = Math.abs(a - x);
            int diff2 = Math.abs(b - x);
            return Integer.compare(diff1, diff2);
        });

        // Copy back to arr[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
    }
}
