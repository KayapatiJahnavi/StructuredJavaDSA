class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        // Check if n is a power of two (only one bit set)
        if ((n & (n - 1)) != 0) return false;

        // Power of four numbers have the single set bit at even positions
        return (n & 0x55555555) != 0;
    }
}
