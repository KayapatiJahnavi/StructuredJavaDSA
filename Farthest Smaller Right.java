class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
    
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        // Coordinate compression of values
        int[] vals = Arrays.copyOf(arr, n);
        Arrays.sort(vals);
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || vals[i] != vals[i - 1]) vals[m++] = vals[i];
        }
        int[] uniq = Arrays.copyOf(vals, m); // uniq values sorted

        // Fenwick tree storing the maximum index seen so far for each value rank
        BIT bit = new BIT(m);

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            // rank index in uniq (0..m-1) because arr[i] is in uniq
            int idx = Arrays.binarySearch(uniq, arr[i]);
            // Query all ranks strictly less than arr[i] -> idx ranks (1..idx)
            int j = (idx > 0) ? bit.query(idx) : -1; // idx==0 => no smaller values
            ans.set(i, j);
            // Update this value's rank with current index i
            bit.update(idx + 1, i); // BIT is 1-indexed
        }
        return ans;
    }

    // Fenwick tree for range max prefix query
    static class BIT {
        int n;
        int[] bit;
        BIT(int n) {
            this.n = n;
            this.bit = new int[n + 2];
            Arrays.fill(this.bit, -1);
        }
        void update(int i, int val) {
            for (; i <= n; i += i & -i) bit[i] = Math.max(bit[i], val);
        }
        int query(int i) {
            int res = -1;
            for (; i > 0; i -= i & -i) res = Math.max(res, bit[i]);
            return res;
        }
    }
}

