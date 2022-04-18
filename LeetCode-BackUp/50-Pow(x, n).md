```
class Solution {
    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        
        if (n == 1) {
            return x;
        }
        
        if (n == -1) {
            return 1 / x;
        }
        
//         double power;
        
//         if (n % 2 == 0) {
//             power = myPow(x, n/2);
//             power = power * power;
//         } else {
//             power = myPow(x, n/2);
//             if (n > 0) {
//                 power = power * power * x;
//             } else {
//                power = power * power * 1 / x;
//             }
//         }
//         return power;
        
        double power = myPow(x, n/2);
        
        if (n % 2 == 0) {
            power = power * power;
        }
        if (n % 2 == 1) {
            power = power * power * x;
        }  
        if (n % 2 == -1) {
            power = power * power * 1 / x;
        }
        return power;
    }
}
```