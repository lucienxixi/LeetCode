// 1010. Pairs of Songs With Total Durations Divisible by 60


// 自己想到了brute force, 看到solution的评论说是2sum的变种，然后自己做了出来。solution1用的hashmap，solution用的sort+双指针

class Solution1 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> remainderToCnt = new HashMap<>();
        int ans = 0;
        
        for (int t : time) {
            if (t % 60 == 0) {
                ans += remainderToCnt.getOrDefault(0, 0);
                remainderToCnt.put(0, remainderToCnt.getOrDefault(0, 0) + 1);
            } else {
                ans += remainderToCnt.getOrDefault(60 - t % 60, 0);
                remainderToCnt.put(t % 60, remainderToCnt.getOrDefault(t % 60, 0) + 1);
            }
        }
        
        return ans;
    }
}


class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Integer[] times = Arrays.stream(time).boxed().toArray(Integer[] :: new);
        Arrays.sort(times, (t1, t2) -> Integer.compare(t1 % 60, t2 % 60));
        int left = 0;
        int right = times.length - 1;
        int ans = 0;
        // System.out.println(Arrays.toString(times));
        
        long count = 0;
        while (left < times.length && times[left] % 60 == 0) {
            count++;
            left++;
        }
        
        if (count >= 2) {
            ans += (int)(count * (count - 1) / 2);
        }
        
        while (left < right) {
            if (times[left] % 60  + times[right] % 60 < 60) {
                left++;
            } else if (times[left] % 60  + times[right] % 60 > 60) {
                right--;
            } else {
                if (times[left] % 60 == 30 && times[right] % 60 == 30) {
                    ans += (right - left + 1) * (right - left) / 2;
                    break;
                }
                
                int countLeft = 1;
                int countRight = 1;
                while (left < right && times[left] % 60  == times[left + 1] % 60) {
                    countLeft++;
                    left++;
                }
                while (left < right && times[right] % 60 == times[right - 1] % 60) {
                    countRight++;
                    right--;
                }
                left++;
                right--;
                // System.out.println(countLeft);
                // System.out.println(countRight);
                ans += countLeft * countRight;
            }
        }
        
        return ans;
    }
}