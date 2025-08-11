class Solution {
    private static final int MOD = 1_000_000_007;
    public int[] productQueries(int n, int[][] queries) {
       
    

    
        // Build powers
        List<Long> powers = new ArrayList<>();
        for (int k = 0; (1L << k) <= n; k++) {
            if (((n >> k) & 1) == 1) {
                powers.add((1L << k) % MOD);
            }
        }

        int m = powers.size();
        long[] pref = new long[m];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                pref[i] = powers.get(i);
            } else {
                pref[i] = (pref[i - 1] * powers.get(i)) % MOD;
            }
        }

        int qLen = queries.length;
        int[] ans = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long res = pref[r];
            if (l > 0) {
                res = res * modInverse(pref[l - 1]) % MOD;
            }
            ans[i] = (int) res;
        }

        return ans;
    }

    // Compute modular inverse via exponentiation
    private long modInverse(long x) {
        return modPow(x, MOD - 2);
    }

    private long modPow(long a, long e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }
}
