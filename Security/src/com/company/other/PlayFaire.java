package com.company.other;

import com.sun.deploy.panel.ITreeNode;

import java.security.Key;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by m7md on 26/11/16.
 */
public class PlayFaire {
    public static char matrix[][] = new char[5][5];
    public static String plain = "please transfer one million dollar";
    public static String key = "monarchy";

    public static ArrayList<String> permutation = new ArrayList<>();


    public static void main(String[] args) {


        CreateMatrix();
        dividePlain();


        System.out.println(decryption(encryption()));








    }

    public static void permutations(String str){




    }




    private static String encryption() {

        String result = "";
        for (String part : permutation) {

            int x = 0, y = 0, x1 = 0, y1 = 0;
            for (int i = 0; i < 5; ++i) {
                String row = String.valueOf(matrix[i]);

                if (row.indexOf(part.charAt(0)) != -1) {
                    x = i;
                    y = row.indexOf(part.charAt(0));
//                    System.out.println(part.charAt(0) + " : " + x + " " + y + "  ");
                }

                if (row.indexOf(part.charAt(1)) != -1) {
                    x1 = i;
                    y1 = row.indexOf(part.charAt(1));
//                    System.out.println(part.charAt(1) + " : " + x + " " + y + " ");
                }
            }


            if (x == x1) {
                y = (y + 1) % 5;
                y1 = (y1 + 1) % 5;
            }

            if (y == y1) {
                x = (x + 1) % 5;
                x1 = (x1 + 1) % 5;
            }

            if (x != x1 && y != y1) {
                int temp = y;
                y = y1;
                y1 = temp;
            }

            result += matrix[x][y] + "" + matrix[x1][y1];


        }
        return result;
    }


    private static String decryption(String cipher) {

        String result = "";
        for (int z = 0; z < cipher.length() - 1; z += 2) {
            int x = 0, y = 0, x1 = 0, y1 = 0;
            for (int i = 0; i < 5; ++i) {
                String row = String.valueOf(matrix[i]);

                if (row.indexOf(cipher.charAt(z)) != -1) {
                    x = i;
                    y = row.indexOf(cipher.charAt(z));
                }

                if (row.indexOf(cipher.charAt(z + 1)) != -1) {
                    x1 = i;
                    y1 = row.indexOf(cipher.charAt(z + 1));
                }
            }

            if (x == x1) {
                y = ((y - 1) + 5) % 5;
                y1 = ((y1 - 1) + 5) % 5;
            }
            if (y == y1) {
                x = ((x - 1) + 5) % 5;
                x1 = ((x1 - 1) + 5) % 5;
            }

            if (x != x1 && y != y1) {
                int temp = y1;
                y1 = y;
                y = temp;
            }

            result += matrix[x][y] + "" + matrix[x1][y1];


        }
        return result;
    }

    private static void dividePlain() {
        plain = plain.replaceAll(" ", "");
        plain = plain.replaceAll("j", "i");
        for (int i = 0; i < plain.length(); i += 2) {
            if (i + 1 < plain.length() && plain.charAt(i) == plain.charAt(i + 1)) {
                if (plain.charAt(i) == 'x')
                    permutation.add(plain.charAt(i) + "" + 'z');
                else
                    permutation.add(plain.charAt(i) + "" + 'x');
                --i;
            } else
                permutation.add(plain.charAt(i) + "" + ((i + 1 >= plain.length()) ? "" : plain.charAt(i + 1)));
        }


        // check list

        String last = permutation.get(permutation.size() - 1);

        if (last.length() < 2)
            if (last.charAt(0) == 'x')
                last += 'z';
            else
                last += 'x';

        permutation.set(permutation.size() - 1, last);

    }

    private static void CreateMatrix() {


        key = key.replace('j', 'i');

        for (int i = 0; i < key.length(); i++) {
            matrix[i / 5][i % 5] = key.charAt(i);
        }
        char alph = 'a';
        for (int i = key.length(); i < 25; ++i) {

            if (key.indexOf(alph) == -1 && alph != 'j')
                matrix[i / 5][i % 5] = alph;
            else
                --i;
            ++alph;

        }
    }


}
