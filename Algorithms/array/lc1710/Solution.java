// 1710. Maximum Units on a Truck

// sloved by myself, in one time
// time: O(nlogn)
// space: O(1)

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> Integer.compare(b2[1], b1[1]));
        int ans = 0;
        int currSize = truckSize;
        
        for (int[] type : boxTypes) {
            if (currSize >= type[0]) {
                ans += type[1] * type[0];
                currSize -= type[0];
            } else {
                ans += type[1] * currSize;
                break;
            }
        }
            
        return ans;
    }
}