// 349. Intersection of Two Arrays

// 题目的意思就是找两个array的交集，交集的元素是unique的，可以无序。第一开始没正确理解题目意思
// 需要复习builtin array转set， lsit转array

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            set2.add(num2);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                list.add(num);
            }
        }
        
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}