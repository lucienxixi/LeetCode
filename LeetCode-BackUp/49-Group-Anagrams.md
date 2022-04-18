```
// solve by myself
// 不需要特定的算法，考察字符串和数组的互相转换，排序，和toString的使用。

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> hashMap = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String[] word = strs[i].split("");
            Arrays.sort(word);
            String wordString = Arrays.toString(word);
            
            List<String> group = hashMap.getOrDefault(wordString, new ArrayList<>());
            group.add(strs[i]);
            hashMap.put(wordString, group);
        }
        
        for (String wordString : hashMap.keySet()) {
            result.add(hashMap.get(wordString));
        }
        
        return result;
    }
}
```