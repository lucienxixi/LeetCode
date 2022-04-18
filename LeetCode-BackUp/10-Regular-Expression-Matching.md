```
// 知道是匹配型dp后，solved by my self
// 最开始没有正确理解题目意思（题目写的不好，没有写清楚*可以删除前一个字母）有的case没有过，之后看了discuss明白了题目的完整意思。
// 知道*也可以代表删除前面的一个字母后，除了recurrence逻辑要加一个情况以为，base case也要改，因为dp[0][j]在p开头为字母和*交错时，可以为true。

/*
题目中"*"的描述有误：
I think the problem`s description for "*" is really really bad.
Actually, * means:
(1). maps nothing
(2). maps nothing and delete the previous char (only the one char ahead)
(3). maps the previous char (only the one char ahead) many times as you want.
*/


/*
base case
dp[0][0] = true
dp[i][0](i>0)= false
dp[0][j](j>0) = 如果p[1~j]都是"字母*字母*字母*"则是true因为一个"*"可以删掉前面一个字母，否则 false

recurrence
if (p[j - 1] == '*')
    if (j > 1) 
    dp[i][j] = dp[i][j - 1] ||    第一种情况：*代表zero
    (p[j - 2] == s[i - 1] && dp[i - 1][j]) ||  第二种情况：*代表前一个字母
    dp[i][j-2] 第三种情况: *代表删除前一个字母
    上面这三种情况都是or的关系，有一个为ture则dp[i][j]就为true
    
    else
    dp[i][j] = dp[i][j - 1]

else if (p[j - 1] == '.')
    dp[i][j] = dp[i - 1][j - 1] 
    
else if (p[j - 1] != '.')
    dp[i][j] = dp[i - 1][j - 1] && p[j - 1] == s[i - 1]

*/

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // base case
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (j < p.length() && p.charAt(j - 1) == '*' && dp[0][j - 2] == true) {
                dp[0][j] = true;
            } else {
                dp[0][j] = false;
            }
        }
        
        //recurrence
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (j > 1) {
                        dp[i][j] = dp[i][j - 1] || 
                                   ((p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && dp[i - 1][j]) || 
                                   dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && p.charAt(j - 1) == s.charAt(i - 1);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}




```