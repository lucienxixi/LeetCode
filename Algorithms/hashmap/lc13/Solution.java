// 13. Roman to Integer

// solved by myself
class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);
        hashMap.put("IV", 4);
        hashMap.put("IX", 9);
        hashMap.put("XL", 40);
        hashMap.put("XC", 90);
        hashMap.put("CD", 400);
        hashMap.put("CM", 900);
        
        int index = 0;
        int ans = 0;
        
        while (index < s.length()) {
            if (index < s.length() - 1 && 
                (
                 (s.charAt(index) == 'I' && (s.charAt(index + 1) == 'V'|| s.charAt(index + 1) == 'X')) ||
                 (s.charAt(index) == 'X' && (s.charAt(index + 1) == 'L' || s.charAt(index + 1) == 'C') ||
                 (s.charAt(index) == 'C' && (s.charAt(index + 1) == 'D' || s.charAt(index + 1) == 'M')))
                )
               )
                {
                    ans += hashMap.get(String.valueOf(s.charAt(index)) + String.valueOf(s.charAt(index + 1)));
                    index += 2;
            } else {
                ans += hashMap.get(String.valueOf(s.charAt(index)));
                index++;
            }
        }
        
        return ans;
        
    }
}