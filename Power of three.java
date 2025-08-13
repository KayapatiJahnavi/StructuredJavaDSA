class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;  // Powers of 3 are positive
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

     System.out.println(isPowerOfThree(1));  // true (3^0)
}
