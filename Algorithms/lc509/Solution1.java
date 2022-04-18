package lc509;
// Fibonacci Number
// 普通做法：从前往后递推 bottom-up
// O(n)


public class Solution1 {
    public int fib(int n) {
        int[] array = new int[n+1];
        if (n == 0) {
            array[0] = 0;
        }
        else if (n == 1) {
            array[1] = 1;
        }
        else {
            for (int i = 2; i < array.length; i++) {
                array[0] = 0;
                array[1] = 1;
                array[i] = array[i-1] + array[i-2];
            }
        }
        return array[n];
    }

    public static void main (String[] args) {
        lc509.Solution1 solution1  = new lc509.Solution1();
        System.out.println(solution1.fib(5));
    }
}