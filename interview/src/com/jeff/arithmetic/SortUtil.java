package com.jeff.arithmetic;

public class SortUtil {

    /**
     * 快速排序
     * @param arr
     */
    public static void quicklySort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            sort(arr, left, index - 1);
        if (index < right)
            sort(arr, index, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

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

    /**
     *  The Straight Insertion Sort
     *  时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
     *  空间复杂度：O(1)
     * @param target
     * @return
     */
    public static void insertSort(int[] target){

        if(target != null && target.length != 1){   // The array size is not null and the site more than 1
            for (int i = 1; i < target.length; i++) {
                for (int j = i; j > 0; j--) {
                    if(target[j]  < target[j-1]){  // Change the data
                        int temp = target[j];
                        target[j] = target[j-1];
                        target[j-1] = temp;
                    }
                }
            }
        }
    }

    public static void shellSort(int[] target){
        if(target != null && target.length != 1){
            int gap = target.length;       // gap个大小为gap的子序列
            do{
                gap = gap/3 + 1;     // 不断缩小gap直至为1
                for (int i = 0 + gap; i < target.length; i++) {   // 对每个子序列进行直接插入排序
                    if(target[i] < target[i-gap]){
                        int j = i - gap;
                        int temp = target[i];         // 待插入值
                        do{
                            target[j + gap] = target[j];         // 后移元素
                            j = j - gap;          // 再比较前一个元素
                        }while(j >= 0 && target[j] > temp);  // 向前比较的终止条件
                        target[j + gap] = temp;         // 将待插入值插入合适的位置
                    }
                }
            }while(gap > 1);
        }
    }
}
