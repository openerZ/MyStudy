package com.mynote;


/**
 * 欧几里得算法：
 * 求最大公因数
 */
public class OJLD {

    public static long gcd(long m, long n) {

        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }

        return m;
    }

    public static void main(String[] args) {
        long gcd = gcd(15, 45);
        System.out.println(gcd);

    }

}
