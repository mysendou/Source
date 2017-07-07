package com.jeff.program;

public class LianXi1 {
    public static void main(String[] arg) {
        int f1 = 1;
        int f2 = 1;
        int max = 24;
        int f;
        System.out.println("第1年有1对兔子");
        System.out.println("第2年有1对兔子");
        for (int i = 3; i < max; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println("第" + i + "年有" + (f2) + "对兔子");
        }
    }
}
