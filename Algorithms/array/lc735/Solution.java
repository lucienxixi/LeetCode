// 735. Asteroid Collision


// 看了tag知道用stack以后，solved by myself
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return null;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
    
                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }
        
        int[] ans = new int[stack.size()]
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        
        return ans;
    }
}