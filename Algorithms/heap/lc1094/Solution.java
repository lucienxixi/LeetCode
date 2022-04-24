// 1094. Car Pooling

// 做完meeting rooms II, 和 Range Addition之后，solved by myself，结合heap和prefixSum

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1, t2) -> Integer.compare(t1[1], t2[1]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((t1, t2) -> Integer.compare(t1[2], t2[2]));
        minHeap.add(trips[0]);
        int prefixSum = trips[0][0];
        if (prefixSum > capacity) {
            return false;
        }
        
        for (int i = 1; i < trips.length; i++) {
            while (!minHeap.isEmpty() && trips[i][1] >= minHeap.peek()[2]) {
                prefixSum -= minHeap.peek()[0];
                minHeap.poll();
            }
            prefixSum += trips[i][0];
            minHeap.add(trips[i]);
            
            if (prefixSum > capacity) {
                return false;
            }
        }
        
        return true;
    }
}