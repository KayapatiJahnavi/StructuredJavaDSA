class Solution {
    public String largestGoodInteger(String num) {
        String maxGood = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                String candidate = num.substring(i, i + 3);
                if (maxGood.equals("") || candidate.compareTo(maxGood) > 0) {
                    maxGood = candidate;
                }
            }
        }
        return maxGood;
    }
}
