// lc1109. Corporate Flight Bookings

// 和370. Range Addition一模一样，只不过index starts at 1
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        
        for (int i = 0; i < bookings.length; i++) {
            ans[bookings[i][0] - 1] += bookings[i][2];
            if (bookings[i][1] - 1 < ans.length - 1) {
                ans[bookings[i][1]] -= bookings[i][2]; 
            }
        }
        
        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i - 1];
        }
        
        return ans;
    }
}