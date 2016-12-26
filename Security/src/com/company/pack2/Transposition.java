package com.company.pack2;

import java.util.ArrayList;

/**
 * Created by m7md on 01/11/16.
 */
public class Transposition {
    public static String alpha = "zaf8#mswoker&";
//    public static String alpha = "abcdefghijklmnopqrstuvwxyz";
    static String key = "megabuck";
    static String plain = "frameworks";

    //    static String cipher = "afllselatooalnmoesilrnnbpaederir";
    public static void main(String[] args) {

        possibleKeys("mkroaresfw");

    }


    static void possibleKeys(String cipher) {

        ArrayList<Integer> keyOrder = getKey(cipher);
        int max = 0;
        for (Integer integer : keyOrder) {
            System.out.print(integer + 1 + " ");
            max = (integer > max) ? integer : max;
        }
        System.out.println();


        if ((alpha.length() - (max + 1)) > 0) {
            System.out.println("some of possible keys  :   " + (alpha.length() - (max + 1)));
        } else {
            System.out.println(alpha);
        }

        for (int i = 0; i < (alpha.length() - (max + 1)); i++) {

            for (int j = 0; j < keyOrder.size(); ++j) {

                System.out.print(alpha.charAt((keyOrder.get(j) + i)));


            }

            System.out.println();


        }


    }


    public static ArrayList<Integer> getKey(String cipher) {

        ArrayList<Integer> keyNumbers = new ArrayList<>();
        String newPlain = plain.replaceAll(" ", "");

        newPlain += alpha.substring(0, (cipher.length() - newPlain.length()));

        if (!cipher.equals(newPlain)) {
            for (int key = 2; key <= alpha.length(); ++key) {
                if (cipher.length() % key == 0) {

                    ArrayList<String> permutations = new ArrayList<>();

                    int rows = cipher.length() / key;
                    String firstCol = "";
                    for (int x = 0; x < rows; ++x) {
                        String part = newPlain.substring(x * key, x * key + key);
                        firstCol += part.charAt(0);
                        permutations.add(part);
                    }

                    if (cipher.contains(firstCol)) {


                        for (int j = 0; j < key; j++) {
                            String col = "";
                            for (int z = 0; z < permutations.size(); ++z) {
                                col += permutations.get(z).charAt(j);
                            }

                            int indexOf = cipher.indexOf(col);

                            if (indexOf % rows != 0) {
                                int length = cipher.substring(0, indexOf + rows).length();
                                indexOf = length + cipher.substring(indexOf + 1).indexOf(col);
                            }

                            /*if (keyNumbers.contains(indexOf / rows)){
                                int length = encrypt.substring(0, indexOf).length() + 1;
                                indexOf = length +rows+ encrypt.substring(indexOf+rows).indexOf(col);
                            }*/

                            cipher = cipher.replaceFirst(cipher.substring(indexOf, indexOf + rows), getEmoijString(rows));

                            keyNumbers.add(indexOf / rows);
                        }
                        break;
                    }

                }
            }
        } else {
            keyNumbers.add(0);
        }


        return keyNumbers;
    }

    public static String getEmoijString(int rows) {
        String result = "";
        for (int i = 0; i < rows; ++i) {
            result += "õ";
        }
        return result;
    }


    static void decrypt(String cipher) {
        char[] sorted = sortKey();
        int setCount = cipher.length() / key.length();
        String[] crypt = new String[key.length()];

        for (int i = 0; i < key.length(); ++i) {
            for (int j = 0; j < sorted.length; ++j)
                if (key.charAt(i) == sorted[j])
                    crypt[i] = cipher.substring(j * setCount, j * setCount + setCount);

        }
        for (int i = 0; i < setCount; ++i) {
            for (int j = 0; j < sorted.length; ++j)

                System.out.print(crypt[j].charAt(i));

        }

        System.out.println();
    }

    static String encrypt() {
        char matrix[][];
        char[] sorted;

        String noSpaces = plain.replaceAll(" ", "");

        int rows = (int) Math.ceil((double) noSpaces.length() / key.length());
        matrix = new char[rows][key.length()];

        int pointer = 0;
        int alpha = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < key.length(); ++j) {
                if (pointer < noSpaces.length())
                    matrix[i][j] = noSpaces.charAt(pointer++);
                else
                    matrix[i][j] = Transposition.alpha.charAt(alpha++);
            }
        }

        sorted = sortKey();

        String result = "";
        for (int i = 0; i < sorted.length; ++i) {

            int index = key.indexOf(sorted[i]);

            for (int j = 0; j < rows; ++j) {
                result += matrix[j][index];

            }
        }
        return result;

    }

    static char[] sortKey() {
        char sorted[] = new char[key.length()];
        short temp[] = new short[alpha.length()];
        short ind = 0;

        for (short i = 0; i < key.length(); ++i) {
            ++temp[alpha.indexOf(key.charAt(i))];
        }


        for (short i = 0; i < temp.length; ++i) {
            if (temp[i] != 0) {
                sorted[ind++] = alpha.charAt(i);
            }
        }

        return sorted;
    }
}