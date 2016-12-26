package com.company.other;

import javax.crypto.Cipher;
import javax.sound.midi.Soundbank;

public class FullyVeginear {

    static String chars[] = new String[27];
    static String str = "abcdefghijklmnopqrstuvwxyz";
    static String plain = "mohamed";
    static String key = "abc";


    public static void main(String[] args) {
          System.out.println(cipher());
        System.out.println(decrypt(cipher()));

    }

    static String cipher() {
        String cipher = "";
        drawMatrix();
        for (int z = 0; z < plain.length(); ++z) {

            int x = str.indexOf(plain.charAt(z));
            int y = str.indexOf(key.charAt(z % key.length()));
            cipher += chars[x + 1].charAt(y);
        }
        return cipher;
    }

    static String decrypt(String cipher) {
        String result = "";

        for (int z = 0; z < cipher.length(); ++z) {

            int x = str.indexOf(key.charAt(z % key.length()));
            int y = chars[x + 1].indexOf(cipher.charAt(z));

            result += str.charAt(y);
        }
        return result;
    }


    static void drawMatrix() {
        for (int i = 0; i < str.length() + 1; ++i) {
            String temp = "";
            System.out.print(((i - 1 < 0) ? " " : str.charAt(i - 1)));
            for (int j = i; j < i + str.length(); ++j) {
                temp += str.charAt(j % str.length());
            }
            System.out.print(temp + " ");

            chars[i] = temp;

            System.out.println("");
        }

    }

}
