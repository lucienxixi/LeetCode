// 1492. The kth Factor of n

// brute force 自己写的
class Solution1 {
    public int kthFactor(int n, int k) {
        int currK = 0;
        
        for (int i = 1; i < n + 1; i++) {
            if (n % i == 0) {
                currK++;
                if (currK == k) {
                    return i;
                }
            }
        }
        
        return -1;
    }
}


// https://www.youtube.com/watch?v=UzVQ9zRVsWg
// better than the solution3 in Leetcode Solution page
// time: O(sqrt(n))
// space: O(1)
class Solution {
    public int kthFactor(int n, int k) {
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i== 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        
        for (int i = (int)Math.sqrt(n); i >= 1; i--) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return n / i;
                }
            }
        }
        
        return -1;
    }
}