class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] digitsOfN = String.valueOf(n).toCharArray();
        Arrays.sort(digitsOfN);
        String sortedN = new String(digitsOfN);

        for (int i = 0; i < 30; i++) {
            int powerOfTwo = 1 << i;
            char[] digitsOfPower = String.valueOf(powerOfTwo).toCharArray();
            Arrays.sort(digitsOfPower);
            String sortedPower = new String(digitsOfPower);

            if (sortedN.equals(sortedPower)) {
                return true;
            }
        }
        return false;
    }
} 
