// 1207. Unique Number of Occurrences


// solved by myself
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        } 
        
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : arr) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> hashSet = new HashSet<>();
        for (int num : hashMap.keySet()) {
            if(hashSet.contains(hashMap.get(num))) {
                return false;
            }
            hashSet.add(hashMap.get(num));
        }
        
        return true;
    }
}