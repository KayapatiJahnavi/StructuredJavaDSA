class Solution {
    public int hIndex(int[] citations) {
        // code here
        
        Arrays.sort(citations);  // sort in ascending order
        int n = citations.length;
        int h = 0;

        // Traverse from highest citation downwards
        for (int i = 0; i < n; i++) {
            int papersWithAtLeastThis = n - i;  // number of papers with citations >= citations[i]
            if (citations[i] >= papersWithAtLeastThis) {
                h = papersWithAtLeastThis;
                break;
            }
        }

        return h;
    }
}


  
