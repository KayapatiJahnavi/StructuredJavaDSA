class Solution {
    public int celebrity(int mat[][]) {
        int n=mat.length;
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                // candidate knows i -> candidate cannot be celeb
                candidate = i;
            }
        }

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;

            // candidate should not know anyone
            if (mat[candidate][i] == 1) return -1;

            // everyone should know candidate
            if (mat[i][candidate] == 0) return -1;
        }

        return candidate;
    }
}
