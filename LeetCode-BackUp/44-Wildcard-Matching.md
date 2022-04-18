```
// 听了讲解做的
// memoization 和 dp 都可以做
// 匹配型dp


/*
dp思想：
boolean dp[i][j] represents the state whether s at i and p at j can match or not.

base case:
dp[0][0] = true
dp[0][j] = if (p[1~j] = "*") true else false
dp[i][0] (i>0) = false

recurrence:
if p[j-1] == "*"
dp[i][j] = dp[i-1][j] || dp[i][j-1]

if p[j-1] != "*"
dp[i][j] = dp[i-1][j-1] && isMatching(s[i - 1], p[j - 1])

*/


class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        
        // base case
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 1]) {
                dp[0][j] = true;
            } else {
                dp[0][j] = false;
            }
        }
        
        //recurrence
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && isMatching(s.charAt(i - 1), p.charAt(j - 1));
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
        
    }
    
    private boolean isMatching(char a, char b) {
        if (a == b) {
            return true;
        }
        
        if (a == '?' || b == '?') {
            return true;
        }

        return false;
    }
}
```