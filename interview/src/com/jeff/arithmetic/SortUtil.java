package com.jeff.arithmetic;

public class SortUtil {

    public static void straightInsertionSort(int[] arr) {
        // 数组的长度
        int sortedLen = arr.length;
        for (int i = 1; i < sortedLen; i++) {
            if (arr[i] < arr[i - 1]) {
                int tmp = arr[i - 1];
                arr[0] = arr[i];
                arr[i] = tmp;
                int insertPos = 0;
                for (int k = i - 1; k >= 0; k--) {
                    if (arr[k] > arr[0]) {
                        arr[k + 1] = arr[k];
                    } else {
                        insertPos = k + 1;
                        break;
                    }
                }
                arr[insertPos] = arr[0];
            }
            System.out.print("第" + (i) + "次排序： ");
           show(arr);
        }
    }

    /**
     * 冒泡排序
     * 
     * @param arr
     */
    public static void bubbling(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] ^= arr[j + 1];
                    arr[j + 1] ^= arr[j];
                    arr[j] ^= arr[j + 1];
                }
                System.out.print("第" + (i + 1) + "次排序： ");
                show(arr);
            }
        }
    }

    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}
