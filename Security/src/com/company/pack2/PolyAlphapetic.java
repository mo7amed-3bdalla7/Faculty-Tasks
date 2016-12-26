package com.company.pack2;

/**
 * Created by m7md on 08/12/16.
 */
public class PolyAlphapetic {
    //abcdefghijklmnopqrstuvwxyz
    static String alpha = "zaf8#mwoker&";
    static String plain = "framework";
    static String key = "r8m";
    static String cipher = "";

//    static String newPlain=plain.replace(" ","");


    public static void main(String[] args) {
//        System.out.println(decrypt(encrypt(plain)));
//        System.out.println((encrypt(plain)));

        System.out.println(encrypt(plain));

        System.out.println(key(plain, "zaw8z&maa"));

    }


    public static String key(String plain, String cipher) {
        String key = "";
        for (int i = 0; i < cipher.length(); ++i) {
            char cipherChar = alpha.charAt(
                    (((alpha.indexOf(cipher.charAt(i))
                            - alpha.indexOf(plain.charAt(i))) % alpha.length()) + alpha.length()) % alpha.length()
            );

            if (key.contains(cipherChar + "")) {
                break;
            }
            key += cipherChar;
        }

        return key;
    }


    public static String encrypt(String plain) {
//        String PlainKey = "";
        String cipher = "";
        for (int i = 0; i < plain.length(); ++i) {
            cipher += alpha.charAt((
                    alpha.indexOf(plain.charAt(i))
                            + alpha.indexOf(key.charAt(i % key.length()))) % alpha.length()
            );
        }
        return cipher;
    }

    public static String decrypt(String cipher) {
        String PlainKey = "";
        String plain = "";
        for (int i = 0; i < cipher.length(); ++i) {
            plain +=
                    alpha.charAt(
                            (((alpha.indexOf(cipher.charAt(i))
                                    - alpha.indexOf(key.charAt(i % key.length()))) % alpha.length()) + alpha.length()) % alpha.length()
                    );
        }

        return plain;
    }


}