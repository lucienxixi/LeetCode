package palindrome.validpalindrome.lc125;
/*
  lc125. Valid Palindrome
  lintcode415. Valid Palindrome

  相向双指针，字符函数，String

  time: O(n)
  space: O(1)
*/


public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isValid(s.charAt(left))) {
                left++;
            }
            while (left < right && !isValid(s.charAt(right))) {
                right--;
            }
//            if (left < right && !isEqual(s.charAt(left), s.charAt(right))) {
//                return false;
//            }
            if (!isEqual(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isValid (char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

    public boolean isEqual (char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    public static void main (String[] args) {
        Solution solution  = new Solution();
        System.out.println(solution.isPalindrome("       a"));
        System.out.println(solution.isPalindrome("a       "));
        System.out.println(solution.isPalindrome(" "));
        System.out.println(solution.isPalindrome(", . ,  "));
        System.out.println(solution.isPalindrome(" a cb, d j n mmdjda, "));

    }
}
