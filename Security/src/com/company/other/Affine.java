package com.company.other;

import java.math.BigInteger;
import java.security.spec.ECField;

/**
 * Created by m7md on 26/11/16.
 */
public class Affine {

    public static String plain = "war lost";
    public static int multiplicativeInverse = 7;
    public static int additiveKey = 10;

    public static void main(String[] args) {


        System.out.println(decrypt(cipher(plain)));
        System.out.println(cipher(plain));

    }

    private static String cipher(String plain) {
        String cipher = "";
        plain = plain.replaceAll(" ", "");
        if (euclideanGcd(multiplicativeInverse, additiveKey) == 1) {
            for (int i = 0; i < plain.length(); i++) {
                cipher += (char) (((multiplicativeInverse * (plain.charAt(i) - 'a') + additiveKey) % 26) + 'a');
            }

        }
        return cipher;
    }

    private static String decrypt(String cipher) {
        String plain = "";
        if (euclideanGcd(26, multiplicativeInverse) == 1) {

            int modInverse = BigInteger.valueOf(multiplicativeInverse).modInverse(BigInteger.valueOf(26)).intValue();

            for (int i = 0; i < cipher.length(); i++) {
                int num = modInverse * (cipher.charAt(i) - 'a' - additiveKey) % 26;

                while (num < 0)
                    num += 26;

                plain += (char) (num + 'a');
            }

        }
        return plain;

    }


    public static int euclideanGcd(int a, int b) {

        if (b == 0)
            return a;
        int r = a % b;
        return euclideanGcd(b, r);
    }

    public static int findKey(String plain ,String cipher){






        return 0;
    }


}
