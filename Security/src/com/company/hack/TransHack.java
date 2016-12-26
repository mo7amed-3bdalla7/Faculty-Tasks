package com.company.hack;

import com.company.pack2.Transposition;


import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by m7md on 20/12/16.
 */
public class TransHack {
    public static void main(String[] args) {
//        System.out.println(check_for_word("please"));

        getKey("afllselatooalnmoesilrnnbpaederir");
    }

    public static ArrayList<Integer> getKey(String cipher) {

        StringBuilder result = new StringBuilder();

        ArrayList<Integer> keyNumbers = new ArrayList<>();

        int wordLength = 0;
//        String result = "";
        for (int key = 2; key <= Transposition.alpha.length() / 2; ++key) {
            if (cipher.length() % key == 0) {

                ArrayList<String> permutations = new ArrayList<>();

                int rows = cipher.length() / key;
                String firstCol = "";
                for (int x = 0; x < key; ++x) {
                    String part = cipher.substring(x * rows, x * rows + rows);
                    firstCol += part.charAt(0);
                    permutations.add(part);
                }

//                if (key == 8) {
                result.append("==============================\n");

                for (int i = 0; i < factorial(1, key); i++) {

                    String plain = "";
                    String en = "";
                    for (int j = 0; j < rows; j++) {
                        for (int z = 0; z < permutations.size(); ++z) {
                            plain += permutations.get(z).charAt(j);
                            en += permutations.get(z).charAt(j);
                        }
                        en += " ";

                    }
                    Collections.shuffle(permutations);
//                        if (plain.contains("pleasetr"))
//                            System.out.println(en);
                    for (int c = 0; c < key - 1; ++c) {
                        String substring = plain.substring((rows - 1) * key + c);
                        if (Transposition.alpha.contains(substring) && substring.length() >= wordLength) {

                            result.append(plain + "\n");
                             /*   for (int z = 2; z < key; ++z) {
                                    if (check_for_word(plain.substring(0, z))) {
                                        result = plain;
                                    }
                                }
                                wordLength = substring.length();
//                                result = plain;
*/
                        }
                    }
                       /* String result = "";
                        for (int c = 1; c < key; ++c) {
                            if (check_for_word(plain.substring(0, c))) {
                                result = plain;
                            }
                        }
                        System.out.println(result);*/
                }
                result.append("==============================\n");

                System.out.println(result);
            }

        }


        return keyNumbers;
    }

    public static boolean check_for_word(String word) {
        // System.out.println(word);
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    "/usr/share/dict/american-english"));
            String str;
            while ((str = in.readLine()) != null) {
                if (str.indexOf(word) != -1) {
                    return true;
                }
            }
            in.close();
        } catch (IOException e) {
        }

        return false;
    }


    static long factorial(long start, long n) {
        long i;
        if (n <= 16) {
            long r = start;
            for (i = start + 1; i < start + n; i++) r *= i;
            return r;
        }
        i = n / 2;
        return factorial(start, i) * factorial(start + i, n - i);
    }

}
