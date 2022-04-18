package binarysearch.lintcode437;
/*
  lintcode437. Copy Books

  思路：
  在答案集上二分
  答案集就是time的范围，先确定minTime和maxTime即答案集的范围，然后进行二分，从而找到最短的时间。
  比如：在一个时间范围内。如果在midTime下，number of copiers可以在<=k的情况下完成抄写，那么在>midTime的情况情况下，也一定可以完成。所以只需要在<=midTime的范围内继续寻找即可。
  所以答案集其实就是true or false组成的，小于最短时间的都是false，大于等于最短时间都是true。这么看来，此种由true or false组成的是适用于二分法的。
 */

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        // 实际上，minTime = pages数组中最大的值，maxTime = pages数组中所有的数之和，但是在这里只需要一个做二分的范围，此范围包括实际的范围就好。
        // int[] pagesCopy = new int[pages.length];
        // System.arraycopy(pages, 0, pagesCopy, 0, pages.length);
        // Arrays.sort(pagesCopy);
        // int minTime = pagesCopy[0];
        // int maxTime = 0;
        // for(int timeOfPagescopy : pagesCopy) {
        //     maxTime += timeOfPagescopy;
        // }
        int minTime = 0, maxTime = Integer.MAX_VALUE;
        while (minTime + 1 < maxTime) {
            int mid = minTime + (maxTime - minTime) / 2;
            if (numberOfCopiers(pages, mid) <= k) {
                maxTime = mid;
            } else {
                minTime = mid;
            }
        }
        if (numberOfCopiers(pages, minTime) <= k) {
            return minTime;
        } else {
            return maxTime;
        }
    }

    private int numberOfCopiers (int[] pages, int timeLimit) {
        int copiers = 1;
        int lastTime = 0;
        for (int timeOfPages : pages) {
            if (timeOfPages > timeLimit) {
                return Integer.MAX_VALUE;
            }
            if ((lastTime + timeOfPages) > timeLimit) {
                copiers++;
                lastTime = 0;
            }
            lastTime += timeOfPages;
        }
        return copiers;
    }
}








