```
class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null) {
            return null;
        }
        
        String longest = "";
        
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = getPalindrome(s, i, i);
            String evenPalindrome = getPalindrome(s, i, i + 1);
            if (longest.length() < oddPalindrome.length()) {
                longest = oddPalindrome;
            }
            if (longest.length() < evenPalindrome.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
        
    }
    
    private String getPalindrome (String s, int left, int right) {
        if (right == s.length()) {
            return s.substring(left, right);
        }
        while (s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            if (left < 0 || right == s.length()){
                break;
            }
        } 
        return s.substring(left + 1, right);
    }
}
```