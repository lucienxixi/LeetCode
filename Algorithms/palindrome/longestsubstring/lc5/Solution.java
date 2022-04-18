package palindrome.longestsubstring.lc5;
// palindrome.longestsubstring.lc5. Longest Palindromic Substring
// 中心线枚举，背向双指针
// time: O(n^2)
// space: O(1)

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("absbbbssbsbsb"));
        System.out.println(solution.longestPalindrome(""));
        System.out.println(solution.longestPalindrome(null));
    }
}