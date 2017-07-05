package com.jeff.arithmetic;

/**
 * 这个例子是个演示冒泡排序
 * @author jeff
 *
 */
public class Demo {
    public static void main(String[] args) {
        int a[] = {45,20,80,40,26,58,66,70};
        SortUtil.show(a);
        SortUtil.straightInsertionSort(a);
        SortUtil.show(a);
    }
    
}
