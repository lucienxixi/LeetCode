package binarysearch.lc302;
/*
  lc302. Smallest Rectangle Enclosing Black Pixels
  lintcode600
 */

class Solution {
    public int minArea(char[][] image, int x, int y) {
        int rowFirstPostion = findFirstPosition(image, true, 0, x);
        int colFirstPostion = findFirstPosition(image, false, 0, y);
        int rowLastPosition = findLastPosition(image, true, x, image.length - 1);
        int colLastPosition = findLastPosition(image, false, y, image[0].length - 1);
        int area = (rowLastPosition - rowFirstPostion + 1) * (colLastPosition - colFirstPostion + 1);
        return area;
    }

    private int findFirstPosition(char[][] image, boolean rowOrCol, int start, int end) {
        boolean ifBlackMid, ifBlackStart;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (rowOrCol) {
                ifBlackMid = checkRow(image, mid);
            } else {
                ifBlackMid = checkColumn(image, mid);
            }

            if (ifBlackMid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (rowOrCol) {
            ifBlackStart = checkRow(image, start);
        } else {
            ifBlackStart = checkColumn(image, start);
        }

        if (ifBlackStart) {
            return start;
        } else {
            return end;
        }
    }

    private int findLastPosition(char[][] image, boolean rowOrCol, int start, int end) {
        boolean ifBlackMid, ifBlackEnd;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (rowOrCol) {
                ifBlackMid = checkRow(image, mid);
            } else {
                ifBlackMid = checkColumn(image, mid);
            }

            if (ifBlackMid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (rowOrCol) {
            ifBlackEnd = checkRow(image, end);
        } else {
            ifBlackEnd = checkColumn(image, end);
        }

        if (ifBlackEnd) {
            return end;
        } else {
            return start;
        }
    }

    private boolean checkRow(char[][] image, int x) {
        for (int j = 0; j < image[x].length; j++) {
            if (image[x][j] == '1') {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(char[][] image, int y) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][y] == '1') {
                return true;
            }
        }
        return false;
    }
}
