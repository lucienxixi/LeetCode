// 696. Count Binary Substrings

// 看了hint后, solved by myself
class Solution {
    public int countBinarySubstrings(String s) {
        int i = 0;
        int j = 0;
        int preCount = 0;
        int curCount = 0;
        int count = 0;
        
        while (i < s.length()) {
            preCount = curCount;
            curCount = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(j)) {
                i++;
                curCount++;
            }
            
            j = i;
            
            if (preCount == 0) {
                continue;
            } else {
                count += Math.min(preCount, curCount);
            }
            
        }
        
        return count;
    }
}