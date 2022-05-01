// 1046. Last Stone Weight
// solved by myself


/*
input:
output:
constraints:
clarity:
*/




/*
logic and pseudocode
[2,7,4,1,8,1]

maxheap
   <-  [8,7,4,2,1,1]  <-

while (maxheap.size() >= 2) {
    poll e1, e2 
    compare(e1, e2)
    e1 != e1 

}

*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
        
        for (int stone : stones) {
            maxHeap.add(stone);    
        }
        
        while (maxHeap.size() >= 2) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();
            if (s1 != s2) {
                maxHeap.add(s1 - s2);
            }
        }
        
        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}


/*
test

case1: 
input: stones = [6]

maxheap = [6]
maxheap.size() == 1
return maxHeap.peek() which is 6
output: 6


case2:
input: stones = [2,2,2,2]

maxheap = [2,2,2,2]
maxheap.size() == 4

while (maxHeap.size() >= 2) {        [2,2,2,2]    [2,2]    [] == 0
        int s1 = maxHeap.poll();     2            2
        int s2 = maxHeap.poll();     2            2
        if (s1 != s2) {          
          maxHeap.add(s1 - s2);
    }
}

return 0 


case3 
input: stones = [2,5,6,13,3,5,31,234,12]


*/