// 347. Top K Frequent Elements

// 看了Solution做的，还差quick select方法没做
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCnt = new HashMap<>();
        for (int num : nums) {
            numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(numToCnt.get(n1), numToCnt.get(n2)));
        
        for (int key : numToCnt.keySet()) {
            minHeap.offer(key);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }
                                                    
        return ans;
        
    }
}