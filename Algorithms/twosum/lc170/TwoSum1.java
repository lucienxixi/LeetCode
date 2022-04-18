package twosum.lc170;
/*
  lc170. Two Sum III - Data structure design
  lintcode607

 */
import java.util.HashMap;
import java.util.Map;

class TwoSum1 {

    Map<Integer, Integer> numToCntMap;

    /** Initialize your data structure here. */
    public TwoSum1() {
        numToCntMap = new HashMap<Integer, Integer>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!numToCntMap.containsKey(number)){
            numToCntMap.put(number, 1);
        } else {
            numToCntMap.put(number, numToCntMap.get(number) + 1);
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer number : numToCntMap.keySet()) {
            if (number != value - number && numToCntMap.containsKey(value - number)) {
                return true;
            }
            if (number == value - number && numToCntMap.get(number) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        TwoSum1 twoSum1 = new TwoSum1();
        twoSum1.add(1);
        twoSum1.add(3);
        twoSum1.add(5);
        System.out.println(twoSum1.find(4));
        System.out.println(twoSum1.find(7));


    }

}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */