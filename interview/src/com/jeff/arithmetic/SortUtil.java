package com.jeff.arithmetic;

public class SortUtil {

    /**
     * 直接插入排序
     * @param arr
     */
    public static void straightInsertionSort2(int[] arr) {
        int i, j, k;
        //从第二个元素开始
        for (i = 1; i < arr.length; i++) {
            //当前检查的元素arr[i]开始往前遍历
            for (j = i - 1; j >= 0; j--) {
                //当前的元素与它前面的元素比较，如果小于前面的某个元素，这时候就要进行插入操作了
                if (arr[j] < arr[i]) {
                    break;
                }
            }
            //记录住当前的元素
            int temp = arr[i];
            //依次将要前面的元素后移（截至到要插入的位置）
            for (k = i - 1; k > j; k--) {
                arr[k+1] =arr[k]; 
            }
            //将要当前元素放入指定的位置
            arr[k+1] = temp;
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
                System.out.print("第" + (i + 1) + "次排序的结果：");
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
