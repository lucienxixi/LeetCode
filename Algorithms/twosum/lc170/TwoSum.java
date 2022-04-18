package twosum.lc170;
/*
  lc170. Two Sum III - Data structure design
  lintcode607

 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TwoSum {

    List<Integer> arraylist;

    /** Initialize your data structure here. */
    public TwoSum() {
        arraylist = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        arraylist.add(number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Set<Integer> hashset = new HashSet<Integer>();
        for (int i = 0; i < arraylist.size(); i++) {
            if (hashset.contains(value - arraylist.get(i))) {
                return true;
            }
            hashset.add(arraylist.get(i));
        }
        return false;
    }

    public static void main (String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));


    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */