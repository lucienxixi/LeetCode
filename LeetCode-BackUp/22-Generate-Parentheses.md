```
class Solution {
    public List<String> generateParenthesis(int n) {
        String[] parenthesisArr = createParenthesisArr(n);
        List<String> results = new ArrayList<>();
        dfs(results, 0, parenthesisArr, "", 0, 0);
        return results;
    }
    
    private void dfs(List<String> results,
                int index,
                String[] parenthesisArr,
                String result,
                int count0,
                int count1) {
    
        if (count0 < count1) {
            return;
        } // 不合法括号情况1
            
        if (result.length() == parenthesisArr.length) {
            if (count0 != count1){
                return;
            }  // 不合法括号情况2
            results.add(result);
            return;
        }
        
        for (int i = 0; i < parenthesisArr[index].length(); i++) {
            if (index == 0 && i == 1) {
                continue;
            }
            if (i == 0) {
                count0++;
            }
            if (i == 1) {
                count1++;
            }
            dfs(results, index + 1, parenthesisArr, result + parenthesisArr[index].charAt(i), count0, count1);
            if (i == 0) {
                count0--;
            }
            if (i == 1) {
                count1--;
            }
        }
    }
    
    private String[] createParenthesisArr(int n) {
        String[] parenthesisArr = new String[2*n];
        for (int i = 0; i < 2*n; i++) {
            parenthesisArr[i] = "()";
        }
        return parenthesisArr;
    }
}
```