// 56. Merge Intervals


// linkedlist arraylist都可以做
// 考察1.customize sort 2.linkedlist/arraylist的api，和list转二维数组
// facebook follow-up: how to do it in large size stream? see in discussion

class Solution1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> mergedList = new LinkedList<>();
        mergedList.add(new int[] {intervals[0][0], intervals[0][1]});
        
        for (int[] interval : intervals) {
            if (mergedList.get(mergedList.size() - 1)[1] >= interval[0]) {
                mergedList.get(mergedList.size() - 1)[1]  = Math.max(mergedList.get(mergedList.size() - 1)[1], interval[1]);
            } else {
                mergedList.add(interval);
            }
        }
        
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}


class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> mergedList = new ArrayList<>();
        mergedList.add(new int[] {intervals[0][0], intervals[0][1]});
        
        for (int[] interval : intervals) {
            if (mergedList.get(mergedList.size() - 1)[1] >= interval[0]) {
                mergedList.get(mergedList.size() - 1)[1]  = Math.max(mergedList.get(mergedList.size() - 1)[1], interval[1]);
            } else {
                mergedList.add(interval);
            }
        }
        
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}