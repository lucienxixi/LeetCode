package interview;

import java.util.Arrays;

public class Test5 {

    public static void main(String[] args) {
        int[] array1 = {1,3,4,5};
        int[] array2 = {2,5,8,9,10,11,20};

        Test5 test = new Test5();
        System.out.println(Arrays.toString(test.merge(array1, array2)));
        System.out.println(Arrays.toString(test.merge1(array1, array2)));
    }

    // 面试的时候写的版本
    public int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < result.length; k++) {
            if (i == arr1.length && j < arr2.length) {
                result[k] = arr2[j];
                j++;
            } else if (j == arr2.length && i < arr1.length) {
                result[k] = arr1[i];
                i++;
            } else if (i < arr1.length && j < arr2.length && arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else if (i < arr1.length && j < arr2.length && arr1[i] > arr2[j]) {
                result[k] = arr2[j];
                j++;
            }
        }

        return result;
    }


    // 优化版本，跟lc88相同
    public int[] merge1(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;

        for (int k = 0; k < result.length; k++) {
            if (i == arr1.length) {
                result[k] = arr2[j];
                j++;
            } else if (j == arr2.length) {
                result[k] = arr1[i];
                i++;
            } else if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else if (arr1[i] > arr2[j]) {
                result[k] = arr2[j];
                j++;
            }
        }

        return result;
    }
}
