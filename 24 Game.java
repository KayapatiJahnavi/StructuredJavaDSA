class Solution {
     private static final double EPSILON = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) nums.add((double) card);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                double a = nums.get(i), b = nums.get(j);

                // all possible results of a and b
                double[] results = {a + b, a - b, b - a, a * b};
                if (Math.abs(b) > EPSILON) results = Arrays.copyOf(results, results.length + 1);
                if (Math.abs(b) > EPSILON) results[results.length - 1] = a / b;
                if (Math.abs(a) > EPSILON) {
                    results = Arrays.copyOf(results, results.length + 1);
                    results[results.length - 1] = b / a;
                }

                for (double val : results) {
                    next.add(val);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}
