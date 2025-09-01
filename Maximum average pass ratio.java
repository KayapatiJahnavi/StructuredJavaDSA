class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-heap ordered by gain of adding one student
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );
        
        for (int[] c : classes) {
            pq.offer(new int[]{c[0], c[1]});
        }
        
        // Assign each extra student optimally
        while (extraStudents-- > 0) {
            int[] cur = pq.poll();
            cur[0]++; // one more pass
            cur[1]++; // one more total
            pq.offer(cur);
        }
        
        // Compute final average
        double sum = 0.0;
        for (int[] c : pq) {
            sum += (double)c[0] / c[1];
        }
        return sum / classes.length;
    }
    
    private double gain(int p, int t) {
        return (double)(p + 1) / (t + 1) - (double)p / t;
    }
}
