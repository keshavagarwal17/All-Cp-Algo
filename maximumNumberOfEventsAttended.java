public maximumNumberOfEventsAttended {
    public static class Solution1 {
        
        public int maxEvents(int[][] events) {
            Arrays.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            int maxEvents = 0;
            int i = 0;
            for (int day = 1; day <= 100000; day++) {
                while (i < events.length && events[i][0] == day) {
                    heap.offer(events[i++][1]);
                }
                while (heap.size() > 0 && heap.peek() < day) {
                    heap.poll();
                }
                if (heap.size() > 0) {
                    heap.poll();
                    maxEvents++;
                }
            }
            return maxEvents;
        }
    }
}
