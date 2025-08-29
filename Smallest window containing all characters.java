class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        // Frequency map for string p
        Map<Character, Integer> freqP = new HashMap<>();
        for (char ch : p.toCharArray()) {
            freqP.put(ch, freqP.getOrDefault(ch, 0) + 1);
        }

        int left = 0, count = 0, minLen = Integer.MAX_VALUE, start = 0;
        Map<Character, Integer> window = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (freqP.containsKey(ch) && window.get(ch) <= freqP.get(ch)) {
                count++;
            }

            // when window has all characters of p
            while (count == p.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // shrink from left
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (freqP.containsKey(leftChar) && window.get(leftChar) < freqP.get(leftChar)) {
                    count--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    
    }
}
