// 1481. Least Number of Unique Integers after K Removals


// 看了tag，solved by myself

// greedy + hashmap + sort
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> numToCnt = new HashMap<>();
        for (int num : arr) {
            numToCnt.put(num, numToCnt.getOrDefault(num, 0) + 1);
        }
        
        Integer[] nums = numToCnt.keySet().toArray(new Integer[0]);
        Arrays.sort(nums, (n1, n2) -> Integer.compare(numToCnt.get(n1), numToCnt.get(n2)));
        
        int ans = nums.length;
        
        for (int num : nums) {
            if (numToCnt.get(num) == k) {
                ans--;
                return ans;
            }  else if (numToCnt.get(num) < k) {
                k -= numToCnt.get(num);
                ans--;
            } else {
                return ans;
            }
        }
        
        return 0;
    }
}

// heap
class Solution1 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
    }        
}














