class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 1;
        long high = (long) Arrays.stream(ranks).max().getAsInt() * cars * cars;
        long result = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canRepair(ranks, cars, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean canRepair(int[] ranks, int cars, long time) {
        long totalCars = 0;
        for (int rank : ranks) {
            totalCars += Math.sqrt(time / rank);
        }
        return totalCars >= cars;
    }
}
