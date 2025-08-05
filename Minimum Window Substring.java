class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // Frequency map for t
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Sliding window variables
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int counter = tMap.size();

        // Frequency map for the window
        HashMap<Character, Integer> window = new HashMap<>();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            window.put(endChar, window.getOrDefault(endChar, 0) + 1);

            if (tMap.containsKey(endChar) && window.get(endChar).equals(tMap.get(endChar))) {
                counter--;
            }

            // Try to shrink the window
            while (counter == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                window.put(startChar, window.get(startChar) - 1);

                if (tMap.containsKey(startChar) && window.get(startChar) < tMap.get(startChar)) {
                    counter++;
                }
                start++;
            }
            end++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}

    
