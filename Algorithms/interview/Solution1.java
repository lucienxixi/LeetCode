package interview;

// Write a function to count the number of words of a particular length in a given string.

//Example:
//count_words(”This is so much fun")
//[(2, 2), (3, 1), (4, 2)]


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//input:
//        String[] = {"This", "is", "so", "much", "fun"};
//
//        output:
//        List<int[]> = [[2, 2], [3, 1], [4, 2]]
//
//
//        MapReduce, Spark
//        Mapper  Reducer
//


class Solution1 {
    public List<int[]> count(String[] wordsArray) {
        List<int[]> results = new ArrayList<>();
        Map<Integer, Integer> lengthToCnt = new HashMap<>();

        for (int i = 0; i < wordsArray.length; i++) {
            lengthToCnt.put(wordsArray[i].length(), lengthToCnt.getOrDefault(wordsArray[i].length(), 0) + 1);
        }

        for (Integer length : lengthToCnt.keySet()) {
            int[] result = new int[2];
            result[0] =length;
            result[1] =lengthToCnt.get(length);
            results.add(result);
        }

        return results;
    }
}

//    String[] = {"This", "is", "so", "much", "fun"};
//        (4, 2)
//        (2, 2)
//        (3, 1)
//
//        [[4,2],[2,2],[3,1]]
//
//    n
//    time complexity: O(2n) = O(n)
//    space complexity: O(n)
//
//
//    map -> ArrayList
//    index: length
//    element: count





