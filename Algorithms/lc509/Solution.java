package lc509;
// lc509. Fibonacci Number
// recursion, dp
// O(2^n)


class Solution {
    //递归的定义：函数：传入参数，返回值，代表的意思
    public int fib(int n) {
        //递归的出口：当传入参数的规模达到最小时(if)，return。
        if(n <= 1) {
            return n;
        }
        //递归的拆解：调用本函数，改变传入参数，从大规模变成小规模
        return fib(n-1) + fib(n-2);
    }

    public static void main (String[] args) {
        lc509.Solution solution  = new lc509.Solution();
        System.out.println(solution.fib(5));
    }
}

