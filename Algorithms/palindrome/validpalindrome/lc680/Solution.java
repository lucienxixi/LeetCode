package palindrome.validpalindrome.lc680;
/*
   lc680. Valid Palindrome II
   lintcode891. Valid Palindrome II

   相向双指针，贪心，函数返回多个数值->新建pair类

   time: O(n)
   space: O(1)

 */

class Solution {
    public boolean validPalindrome(String s) {
        if (s == null) {
            return false;
        }

        Pair pair = findDifference(s, 0, s.length() - 1);
        if (pair.left >= pair.right) {    // 当String中字符为奇数时是=，当String中字符为偶数时是>.
            return true;
        }

        return isPalindrome(s, pair.left + 1, pair.right) || isPalindrome(s, pair.left, pair.right - 1);
    }

    private Pair findDifference(String s, int left, int right) {
        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        return new Pair(left, right);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
//        Pair pair = findDifference(s, left, right);
//        return pair.left >= pair.right;
    }
    private class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main (String[] args) {
        Solution solution  = new Solution();
        System.out.println(solution.validPalindrome("abba"));
    }
}
