import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class test3 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
//        s1 += "peter";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));


        test3 test = new test3();
        test.function(5);
        test.function1(s1 + "haha");
        System.out.println(s1);

        List<Integer>[] listArray = new List[10];
        Map<Integer, String>[] mapArray = new Map[10];
        Map<List<Integer>, String> mapList = new HashMap<>();
        List<Integer> linkedlist = new LinkedList<>();
    }

    private void function1(String s1) {
        System.out.println(s1);
    }




    protected void function(int n) {
        System.out.println(n);
        function1(n - 1);
        System.out.println(n);

        int n1 = n - 1;
        System.out.println(n);
        function1(n1);
        System.out.println(n);
    }

    private void function1(int n) {
        System.out.println(n);
    }
}
