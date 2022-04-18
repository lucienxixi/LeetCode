```
// solve by myself
// brute force
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];    
        } 
        
        String longestCommonPrefix = "";
        int maxLength = 200;
        for (int i = 0; i < strs.length - 1; i++) {
            String currCommonPrefix = getCommonPrefix(strs[i], strs[i + 1]);
            if (currCommonPrefix.length() < maxLength) {
                longestCommonPrefix = currCommonPrefix;
                maxLength = longestCommonPrefix.length();
            }
        }
        return longestCommonPrefix;
    }
    
    private String getCommonPrefix(String a, String b) {
        for (int i = 1; i < Math.min(a.length(), b.length()) + 1; i++) {
            if (!a.substring(0, i).equals(b.substring(0, i))) {
                return(a.substring(0, i - 1));
            }
        }
        return a.substring(0, Math.min(a.length(), b.length()));
    }
}
```