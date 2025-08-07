class Solution {
    public int minDifference(String[] arr) {
        int[] seconds = new int[arr.length];

        // Convert all time strings to total seconds
        for (int i = 0; i < arr.length; i++) {
            String[] parts = arr[i].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            seconds[i] = h * 3600 + m * 60 + s;
        }

        // Sort the seconds
        Arrays.sort(seconds);

        int minDiff = Integer.MAX_VALUE;

        // Compare consecutive time differences
        for (int i = 1; i < seconds.length; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }

        // Wrap around midnight: compare last and first
        int wrapDiff = 86400 - seconds[seconds.length - 1] + seconds[0]; // 86400 = 24 * 3600
        minDiff = Math.min(minDiff, wrapDiff);

        return minDiff;
    }
}
