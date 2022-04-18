```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> hashSet = new HashSet<>();
        hashSet.add(s.charAt(0));
        int j = 1;
        int maxLength = 1;
        int currentLength = 1;
  
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j));
                j++;
                currentLength++;
            }
            
            maxLength = Math.max(currentLength, maxLength);
            
            if (j >= s.length()) {
                break;
            }
            
            hashSet.remove(s.charAt(i));
            currentLength--;
        }
        return maxLength;
    }
}
```