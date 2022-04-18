public class test2 {
    int a;
    int b;
    public static void main(String[] args) {
        test2 test = new test2();
        test.helper();
    }

    private void helper() {
        a = 1;
        b = 2;
        sum();
        System.out.println(a);
        System.out.println(b);
    }
    private void sum () {
//        if (a + b > 10) {
//            return;
//        }
//        a++;
//        sum(a + 1, b + 1);

        sum2();
//        System.out.println(a);
//        System.out.println(b);
    }


    private void sum2() {
        a = a + 100;
    }
}
