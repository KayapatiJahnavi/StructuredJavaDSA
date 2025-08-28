class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Map for diagonals: key = row - col
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Collect diagonals
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(grid[i][j]);
            }
        }

        // Step 2: Sort diagonals
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> diag = entry.getValue();
            if (key >= 0) {
                // Bottom-left including main diagonal → sort descending
                diag.sort(Collections.reverseOrder());
            } else {
                // Top-right → sort ascending
                Collections.sort(diag);
            }
        }

        // Step 3: Place values back into grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                List<Integer> diag = map.get(key);
                grid[i][j] = diag.remove(0);
            }
        }

        return grid;
    }
}
