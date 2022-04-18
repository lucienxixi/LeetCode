import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 2, 3};
        int[] array2 = new int[]{1, 2, 3};
        Set<int[]> hashSet = new HashSet<>();
        hashSet.add(array1);

        if (array1.equals(array2)) {
            System.out.println("true");
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>(list1);
        Set<List> hashSet1 = new HashSet<>();
        hashSet1.add(list1);
        if (list1.equals(list2)) {
//            System.out.println("true");
        }

        String string = ",,,,,,1,1,,1,2,3,4,5";
        String[] stringArray = string.substring(0, string.length() - 2).split(",");
        System.out.print(stringArray[0]);


        String string1 = "let1 art zero can";
        String[] stringArr = string1.split(" ", 2);
        System.out.println(Arrays.toString(stringArr));
        System.out.println(stringArray.length);
        for (String s : stringArray) {
            System.out.print(s);
        }
    }
    }

