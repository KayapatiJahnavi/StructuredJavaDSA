class Solution {
    public long flowerGame(long n, long m) {
        long oddN = (n + 1) / 2; // odds in [1..n]
        long evenN = n / 2;      // evens in [1..n]
        long oddM = (m + 1) / 2; // odds in [1..m]
        long evenM = m / 2;      // evens in [1..m]

        return oddN * evenM + evenN * oddM;
    }
}
