class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> path, List<String> result) {
        // If we have 4 parts and reached the end of the string → valid IP
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try segment lengths 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;
            String segment = s.substring(index, index + len);

            // Skip invalid segments
            if (!isValid(segment)) continue;

            path.add(segment);
            backtrack(s, index + len, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false; // no leading zero
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
