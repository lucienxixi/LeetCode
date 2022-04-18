```
class Solution1 {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> results = new ArrayList<>();
        dfs(digits, letters, "", results, 0);
        return results;

    }
    
    private void dfs(String digits, String[] letters, String combination, List<String> results, int index) {
        if(digits == null || digits.length() == 0) {
            return;
        }
        
        if (digits.length() == index) {
            results.add(combination);
            return;
        }
        
        
        // for (int i = 0; i < letters[Integer.parseInt(String.valueOf(digits.charAt(index)))].length(); i++) {
        //     String newCombination = combination +                                                   letters[Integer.parseInt(String.valueOf(digits.charAt(index)))].charAt(i);
        //     int newIndex = index + 1;
        //     dfs (digits, letters, newCombination, results, newIndex);
        // }
        
        int digit = Integer.parseInt(String.valueOf(digits.charAt(index)));
        // int digit = digits.charAt(index) - '0'; // char 转 int，等价于上一句
        for (int i = 0; i < letters[digit].length(); i++) {
            String newCombination = combination + letters[digit].charAt(i);
            int newIndex = index + 1;
            dfs (digits, letters, newCombination, results, newIndex);
        }
    }
}


// StringBuilder版本
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> results = new ArrayList<>();
        dfs(digits, letters, new StringBuilder(), results, 0);
        return results;

    }
    
    private void dfs(String digits, String[] letters, StringBuilder combination, List<String> results, int index) {
        if(digits == null || digits.length() == 0) {
            return;
        }  
        
        if (digits.length() == index) {
            results.add(combination.toString());
            return;
        }

        int digit = Integer.parseInt(String.valueOf(digits.charAt(index)));

        for (int i = 0; i < letters[digit].length(); i++) {
            combination.append(letters[digit].charAt(i));
            int newIndex = index + 1;
            dfs (digits, letters, combination, results, newIndex);
            combination.deleteCharAt(combination.length() - 1); // StringBuilder 引用数据类型需要手动回溯
        }
    }
}











// 构建图，然后dfs，待研究。

// class Solution1 {
//     public List<String> letterCombinations(String digits) {
//         Map<String, List<String>> directGrap = createDirectGraph(digits);
//         List<String> results = new ArrayList<>();
//         String result = "";
//         dfs(directGrap, results, result);
//         return results;
//     }
    
//     private dfs(Map<String, List<String>> directGrap, List<String> results, String result) {
        
//     }
    
//     private Map<String, List<String>> createDirectGraph(String digits) {
//         Map<String, String> phoneNumber = new HashMap<>();
//         phoneNumber.put("2", "abc");
//         phoneNumber.put("3", "def");
//         phoneNumber.put("4", "ghi");
//         phoneNumber.put("5", "jkl");
//         phoneNumber.put("6", "mno");
//         phoneNumber.put("7", "pqrs");
//         phoneNumber.put("8", "tuv");
//         phoneNumber.put("9", "wxyz");
        
//         Map<String, List<String>> directGrap = new HashMap<>();
//         for (int i = 1; i < digits.length(); i++) {
//             String lettersU = phoneNumber.get(String.valueOf(digits.charAt(i - 1)));
//             for (int j = 0; j < lettersU.length(); j++) {
//                 List<String> listV = new ArrayList<>();
//                 String lettersV = phoneNumber.get(String.valueOf(digits.charAt(i)));
//                 for (int k = 0; k < lettersV.length(); k++) {
//                     listV.add(String.valueOf(lettersV.charAt(k)));
//                 }
//                 directGrap.put(String.valueOf(lettersU.charAt(j)), listV);
//             }
//         }
//         return directGrap;
//     }
// }
```