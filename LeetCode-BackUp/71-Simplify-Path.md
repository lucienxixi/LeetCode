```
// solved by myself ,看了hint要用stack
// stringbuilder可以代替stack，省了O(n)空间
// 查缺补漏 linux路径知识
// 查漏补缺字符串比较 ==和equals
// 查漏补缺stringbuilder.delete 和 deletecharat都是基于char的index
class Solution {
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        String[] pathArr = path.split("/");

        for (int i = 0; i < pathArr.length; i++) {
            if (pathArr[i].equals("") || pathArr[i].equals("/") || pathArr[i] .equals(".") ||
                (pathArr[i] .equals("..") && ans.length() == 0)) {
                continue;
            } else if (pathArr[i] .equals("..") && ans.length() > 0) {
                int deleteLength = 0;
                int index = ans.length() - 1;
                while (ans.charAt(index) != '/') {
                    deleteLength++;
                    index--;
                }
                ans.delete(ans.length() - (deleteLength + 1),ans.length());
            } else {
                ans.append("/" + pathArr[i]);
            }
        }
    
        if (ans.length() == 0) {
            ans.append("/");
        }
        
        return ans.toString();
    }
}
```