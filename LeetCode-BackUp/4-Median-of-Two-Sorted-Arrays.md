```
// merge
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        
        for (int k = 0; k < temp.length; k++) {
            if (i == nums1.length) {
                temp[k] = nums2[j];
                j++;
            } else if (j == nums2.length) {
                temp[k] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
        }
        
        if (temp.length % 2 != 0) {
            return temp[temp.length / 2];
        } else {
            return (double)(temp[temp.length / 2] + temp[temp.length / 2 - 1]) / 2;
        }
    }
}

```