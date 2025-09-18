class TaskManager {
private final Map<Integer, int[]> mp = new HashMap<>();
    private final PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(b[0], a[0]);
            return Integer.compare(b[1], a[1]);
        }
    );
    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            mp.put(taskId, new int[]{priority, userId});
            pq.add(new int[]{priority, taskId});
        }
    }

    public void add(int userId, int taskId, int priority) {
        mp.put(taskId, new int[]{priority, userId});
        pq.add(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        int[] cur = mp.get(taskId);
        if (cur == null) return;
        int userId = cur[1];
        mp.put(taskId, new int[]{newPriority, userId});
        pq.add(new int[]{newPriority, taskId});
    }

    public void rmv(int taskId) {
        mp.remove(taskId); 
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int p = top[0], id = top[1];
            int[] info = mp.get(id);
            if (info != null && info[0] == p) {
                int userId = info[1];
                mp.remove(id);
                return userId;
            }
        }
        return -1;
    }
}
