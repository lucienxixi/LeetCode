// 907. Sum of Subarray Minimums


// based on LC496 Next Greater Element 1
// monotonous stack + math
// montonous stack: to find the nearest nextMin and the nearest prevMin
// math: acccording to the index of nextMin and the index of prevMin to calculate the number of subarray between nextMin and prevMin. number = (i - index of prevMin) * (index of nextMin - i), sum = number * arr[i], which means the min of all of the subarrays between nextMin and prevMin is arr[i]

class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long[] nextMin = new long[arr.length];
        long[] prevMin = new long[arr.length];
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                nextMin[i] = arr.length;
            } else {
                nextMin[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        
        stack.clear();
        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                prevMin[i] = -1;
            } else {
                prevMin[i] = stack.peek();
            }
            
            stack.push(i);
        }
        
        // System.out.println(Arrays.toString(nextMin));
        // System.out.println(Arrays.toString(prevMin));
        
        long sum = 0L;
        int mod = 1_000_000_007;
        
        for (int i = 0; i < arr.length; i++) {            
            sum += arr[i] * (nextMin[i] - i) * (i - prevMin[i]);    
        }
        
        long ans = sum % mod;
        return (int)ans;
    }
}