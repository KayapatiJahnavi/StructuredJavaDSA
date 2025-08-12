class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices); // sort ascending
        int n = prices.length;
        int minCost = 0, maxCost = 0;

        // Minimum cost calculation
        int l = 0, r = n - 1;
        while (l <= r) {
            minCost += prices[l];
            l++;
            r -= k; // take k most expensive free
        }

        // Maximum cost calculation
        l = 0; r = n - 1;
        while (l <= r) {
            maxCost += prices[r];
            r--;
            l += k; // take k cheapest free
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(minCost);
        ans.add(maxCost);
        return ans;
    }
}
