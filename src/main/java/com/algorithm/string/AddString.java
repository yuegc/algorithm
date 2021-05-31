package com.algorithm.string;

import java.util.Scanner;

/**
 * @author: yuegc
 * @Date: 2021/5/31 15:22
 * @Description: 两个未知数字字符串相加
 */
public class AddString {
    public static  String add(String string1,String string2) {
        //反转字符串,从最小为往上加
        StringBuffer s1 = new StringBuffer(string1).reverse();
        StringBuffer s2 = new StringBuffer(string2).reverse();
        StringBuffer res = new StringBuffer();

        int len1 = s1.length();
        int len2 = s2.length();
        int len;
        //获取最长的字符串，短的字符串补0对齐
        if (len1 < len2) {
            len = len2;
            int count = len2 - len1;
            while (count-- > 0) {
                s1.append('0');
            }
        } else {
            len = len1;
            int count = len1 - len2;
            while (count-- > 0) {
                s2.append('0');
            }
        }

        int overflow = 0;
        int num;
        //相加，满10进位
        for (int i = 0; i < len; i++) {
            num = s1.charAt(i) - '0' + s2.charAt(i) - '0' + overflow;
            if (num >= 10) {
                overflow = 1;
                num -= 10;
            } else {
                overflow = 0;
            }
            res.append(num);
        }

        if (overflow == 1) {
            res.append(1);
        }
        //反转最后结果
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串1:");
        String string1 = input.nextLine();
        System.out.print("请输入字符串2:");
        String string2 = input.nextLine();

        System.out.println("第一种方法输出的字符串是：" + add(string1, string2));
    }
}
