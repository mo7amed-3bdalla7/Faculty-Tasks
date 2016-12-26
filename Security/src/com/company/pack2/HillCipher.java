package com.company.pack2;

import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by m7md on 07/12/16.
 */
public class HillCipher {


    static String alpha = "t&he9n#d";


    public static void main(String[] args) {

//        System.out.println(euclideanGcd(2,26));
        findKey("theend", "e#h&n&");













/*
        System.out.println(encryption("retr",new int[][]{
                {1,0,2},
                {10,20,15},
                {0,1,2}

        }));*/
//        System.out.println(encryption("aaa", new int[][]{
//                {25, 25},
//                {25, 18}
//        }));

//        getKey("xzm", "xlm");
/*        System.out.println(BigInteger.valueOf(9).modInverse(BigInteger.valueOf(26)));
        System.out.println(euclideanGcd(26, 12));*/
//        getKey("xzm", "xlm");
//        getKey("aaa", "aaa");
//        getKey("sho", "apa");
       /* int key[][] = {
                {1, 16},
                {1, 7}
        };*/
//        System.out.println(encryption("shortexample",key));


/*

        if (euclideanGcd(matrixValue(key), alpha.length()) == 1) {
            System.out.println(encryption(plain));
        } else {
            System.out.println("lef we erg3 tany");
        }
*/


    }


    @Nullable
    public static void findKey(String plain, String cipher) {
        /*plain=plain.replaceAll(" ","");
        encrypt=encrypt.replaceAll(" ","");*/


        int parameters[][] = new int[2][2];
        int ciphers[][] = new int[2][2];
        int it = (plain.length() >= 4) ? 2 : 1;
        for (int i = 0; i < it; ++i) {
            parameters[i][0] = alpha.indexOf(plain.charAt(2 * i));
            parameters[i][1] = alpha.indexOf(plain.charAt(2 * i + 1));
            ciphers[i][0] = alpha.indexOf(cipher.charAt(2 * i));
            ciphers[i][1] = alpha.indexOf(cipher.charAt(2 * i + 1));
        }
        ArrayList<int[][]> matrix2 = checks2(parameters, ciphers, plain, cipher);
        display(matrix2);
        if (plain.length() > 2) {
            int parameters3[][] = new int[3][3];
            int ciphers3[][] = new int[3][3];
            int it3 = (cipher.length() >= 9) ? 3 : (cipher.length() >= 6) ? 2 : 1;
            for (int i = 0; i < it3; ++i) {
                parameters3[i][0] = alpha.indexOf(plain.charAt(3 * i));
                parameters3[i][1] = alpha.indexOf(plain.charAt(3 * i + 1));
                parameters3[i][2] = alpha.indexOf(plain.charAt(3 * i + 2));
                ciphers3[i][0] = alpha.indexOf(cipher.charAt(3 * i));
                ciphers3[i][1] = alpha.indexOf(cipher.charAt(3 * i + 1));
                ciphers3[i][2] = alpha.indexOf(cipher.charAt(3 * i + 2));
            }

            ArrayList<int[][]> matrix3 = checks3(parameters3, ciphers3, plain, cipher);
            display(matrix3);

        }
    }


    public static void display(ArrayList<int[][]> matrix2) {
        if (matrix2.size() > 0)
            System.out.println("possible keys in matrix " + matrix2.get(0).length + "x" + matrix2.get(0).length + " : " + matrix2.size());
        for (int[][] possibleKey : matrix2) {
            String keyStr = "[";

            for (int i = 0; i < possibleKey.length; ++i) {
                keyStr += "{";
                for (int j = 0; j < possibleKey[0].length; ++j) {
                    keyStr += possibleKey[i][j] + ",";
                }
                keyStr += "}";

            }
            keyStr += "]";

            System.out.println(keyStr);
        }


    }


    public static ArrayList<int[][]> checks2(int[][] parameters, int[][] ciphers, String plain, String cipher) {


        ArrayList<int[]> ab = new ArrayList<>();
        ArrayList<int[]> cd = new ArrayList<>();
        if (plain.length() >= 4) {
            for (int i = 0; i < alpha.length(); ++i) {
                for (int j = 0; j < alpha.length(); ++j) {
                    if ((parameters[0][0] * i + parameters[0][1] * j) % alpha.length() == ciphers[0][0]
                            && (parameters[1][0] * i + parameters[1][1] * j) % alpha.length() == ciphers[1][0]) {
                        ab.add(new int[]{i, j});
                    }
                    if ((parameters[0][0] * i + parameters[0][1] * j) % alpha.length() == ciphers[0][1]
                            && (parameters[1][0] * i + parameters[1][1] * j) % alpha.length() == ciphers[1][1]) {
                        cd.add(new int[]{i, j});
                    }
                }

            }
        } else {

            for (int i = 0; i < alpha.length(); ++i) {
                for (int j = 0; j < alpha.length(); ++j) {
                    if ((parameters[0][0] * i + parameters[0][1] * j) % alpha.length() == ciphers[0][0]) {
                        ab.add(new int[]{i, j});
                    }
                    if ((parameters[0][0] * i + parameters[0][1] * j) % alpha.length() == ciphers[0][1]) {
                        cd.add(new int[]{i, j});
//                        System.out.println(i+" "+j);
                    }
                }

            }


        }


        ArrayList<int[][]> possibleKeys = new ArrayList<>();
        int possible = 0;
        for (int[] abRow : ab) {
            if (possible > 20) {
                break;
            }
            for (int[] cdRow : cd) {
                if (possible > 20) {
                    break;
                }
                int[][] tmpKey = new int[][]{
                        {abRow[0], abRow[1]},
                        {cdRow[0], cdRow[1]}
                };
                if (euclideanGcd(matrixValue(tmpKey), alpha.length()) == 1) {

                    String encryption = encryption(plain, tmpKey);
                    if (plain.length() < 4 && encryption.contains(cipher.substring(0, 2))) {
                        ++possible;
                        possibleKeys.add(tmpKey);
                    }

                    if (encryption.equals(cipher)) {
                        ++possible;
                        possibleKeys.add(tmpKey);

                    }
                }

            }
        }

        return possibleKeys;

    }

    public static ArrayList<int[][]> checks3(int[][] parameters, int[][] ciphers, String plain, String cipher) {


        ArrayList<int[]> abc = new ArrayList<>();
        ArrayList<int[]> def = new ArrayList<>();
        ArrayList<int[]> ghi = new ArrayList<>();
        if (plain.length() >= 9) {
            for (int i = 0; i < alpha.length(); ++i) {
                for (int j = 0; j < alpha.length(); ++j) {
                    for (int k = 0; k < alpha.length(); ++k) {
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][0]
                                && (parameters[1][0] * i + parameters[1][1] * j + parameters[1][2] * k) % alpha.length() == ciphers[1][0]
                                && (parameters[2][0] * i + parameters[2][1] * j + parameters[2][2] * k) % alpha.length() == ciphers[2][0]) {
                            abc.add(new int[]{i, j, k});
                        }
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][1]
                                && (parameters[1][0] * i + parameters[1][1] * j + parameters[1][2] * k) % alpha.length() == ciphers[1][1]
                                && (parameters[2][0] * i + parameters[2][1] * j + parameters[2][2] * k) % alpha.length() == ciphers[2][1]) {

                            def.add(new int[]{i, j, k});
                        }
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][2]
                                && (parameters[1][0] * i + parameters[1][1] * j + parameters[1][2] * k) % alpha.length() == ciphers[1][2]
                                && (parameters[2][0] * i + parameters[2][1] * j + parameters[2][2] * k) % alpha.length() == ciphers[2][2]) {

                            ghi.add(new int[]{i, j, k});
                        }
                    }
                }

            }
        } else if (plain.length() >= 6) {

            for (int i = 0; i < alpha.length(); ++i) {
                for (int j = 0; j < alpha.length(); ++j) {
                    for (int k = 0; k < alpha.length(); ++k) {
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][0]
                                && (parameters[1][0] * i + parameters[1][1] * j + parameters[1][2] * k) % alpha.length() == ciphers[1][0]) {
                            abc.add(new int[]{i, j, k});
                        }
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][1]
                                && (parameters[1][0] * i + parameters[1][1] * j + parameters[1][2] * k) % alpha.length() == ciphers[1][1]) {

                            def.add(new int[]{i, j, k});
                        }
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][2]
                                && (parameters[1][0] * i + parameters[1][1] * j + parameters[1][2] * k) % alpha.length() == ciphers[1][2]) {

                            ghi.add(new int[]{i, j, k});
                        }
                    }
                }

            }


        } else {

            for (int i = alpha.length() - 1; i >= 0; --i) {
                for (int j = alpha.length() - 1; j >= 0; --j) {
                    for (int k = alpha.length() - 1; k >= 0; --k) {
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][0]) {
                            abc.add(new int[]{i, j, k});
                        }
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][1]) {

                            def.add(new int[]{i, j, k});
                        }
                        if ((parameters[0][0] * i + parameters[0][1] * j + parameters[0][2] * k) % alpha.length() == ciphers[0][2]) {

                            ghi.add(new int[]{i, j, k});
                        }
                    }

                }


            }


        }


        ArrayList<int[][]> possibleKeys = new ArrayList<>();
        int possible = 0;
        for (int[] abcRow : abc) {
            if (possible > 20) {
                break;
            }
            for (int[] defRow : def) {
                if (possible > 20) {
                    break;
                }
                for (int[] ghiRow : ghi) {
                    if (possible > 20) {
                        break;
                    }
                    int[][] tmpKey = new int[][]{
                            {abcRow[0], abcRow[1], abcRow[2]},
                            {defRow[0], defRow[1], defRow[2]},
                            {ghiRow[0], ghiRow[1], ghiRow[2]}
                    };
                    if (euclideanGcd(matrixValue(tmpKey), alpha.length()) == 1) {

                        String encryption = encryption(plain, tmpKey);
//                        System.out.println("ggggggg");
                        if (encryption.equals(cipher)) {
                            possibleKeys.add(tmpKey);
                            ++possible;
                            //      System.out.println(tmpKey);
                            break;
                        } else if (plain.length() < 6 && encryption.contains(cipher.substring(0, 3))) {
//                            System.out.println(tmpKey);
//                            break;
                            ++possible;
                            possibleKeys.add(tmpKey);
                        } else if (plain.length() < 9 && encryption.contains(cipher.substring(0, 6))) {
                            ++possible;
                            possibleKeys.add(tmpKey);
                        }

//                        System.out.println("dfdfdf");
                    }

                }

            }

        }

        return possibleKeys;

    }


    public static int[][] inverse(int key[][], String alpha) {
        int keyInverse[][] = new int[key.length][key.length];
        int matrixValue = ((matrixValue(key) % alpha.length()) + alpha.length()) % alpha.length();

        if (key.length > 2) {
            short sign = 1;
            for (int i = 0; i < key.length; ++i) {
                for (int j = 0; j < key.length; ++j) {
                    if (i - j == -1 || i - j == 1) {
                        keyInverse[j][i] = (key[(i + 2) % key.length][(j + 1) % key.length] * key[(i + 1) % key.length][(j + 2) % key.length])
                                - key[(i + 1) % key.length][(j + 1) % key.length] * key[(i + 2) % key.length][(j + 2) % key.length];
                    } else {
                        keyInverse[j][i] = key[(i + 1) % key.length][(j + 1) % key.length] * key[(i + 2) % key.length][(j + 2) % key.length]
                                - (key[(i + 2) % key.length][(j + 1) % key.length] * key[(i + 1) % key.length][(j + 2) % key.length]);
                    }

                    if (sign == 0) {
                        keyInverse[j][i] *= -1;
                    }
                    sign ^= 1;
                    keyInverse[j][i] *= BigInteger.valueOf(matrixValue).modInverse(BigInteger.valueOf(alpha.length())).intValue();
                }
            }
        } else {
            int matrixValueInverse = BigInteger.valueOf(matrixValue)
                    .modInverse(BigInteger.valueOf(alpha.length())).intValue();

            keyInverse[0][0] = ((key[1][1] * matrixValueInverse % alpha.length()) + alpha.length()) % alpha.length();
            keyInverse[0][1] = ((-key[0][1] * matrixValueInverse % alpha.length()) + alpha.length()) % alpha.length();
            keyInverse[1][0] = ((-key[1][0] * matrixValueInverse % alpha.length()) + alpha.length()) % alpha.length();
            keyInverse[1][1] = ((key[0][0] * matrixValueInverse % alpha.length()) + alpha.length()) % alpha.length();


        }


        return keyInverse;
    }


    public static String decryption(String cipher, int key[][]) {
        ArrayList<String> divideCipher = dividePlain(cipher, key);
        String plain = "";
        int[] multiply;
        for (String subCipher : divideCipher) {
            int col[] = new int[key.length];
            for (int i = 0; i < key.length; i++) {
                col[i] = alpha.indexOf(subCipher.charAt(i));
            }

            multiply = multiplyMatrix(inverse(key, alpha), col, alpha);

            for (int i = 0; i < multiply.length; ++i) {
                plain += alpha.charAt(multiply[i]);
            }
        }

        return plain;
    }


    public static String encryption(String plain, int key[][]) {
        ArrayList<String> dividePlain = dividePlain(plain, key);
        String cipher = "";
        int[] multiply;
        for (String subPlain : dividePlain) {
            int col[] = new int[key.length];
            for (int i = 0; i < key.length; i++) {
                col[i] = alpha.indexOf(subPlain.charAt(i));
            }

            multiply = multiplyMatrix(key, col, alpha);

            for (int i = 0; i < multiply.length; ++i) {
                cipher += alpha.charAt(multiply[i]);
            }
        }

        return cipher;
    }


    public static int[] multiplyMatrix(int[][] a, int[] b, String alpha) {
        int rowsInA = a.length;
        int columnsInB = b.length;
        int[] c = new int[columnsInB];
        for (int i = 0; i < rowsInA; i++) {
            for (int k = 0; k < columnsInB; k++) {
                c[i] = ((c[i] + a[i][k] * b[k]) % alpha.length() + alpha.length()) % alpha.length();
            }

        }
        return c;
    }


    public static int matrixValue(int key[][]) {
        int matrixValue;
        if (key[0].length > 2) {
            matrixValue = key[0][0] * (key[1][1] * key[2][2] - key[1][2] * key[2][1])
                    - key[0][1] * (key[1][0] * key[2][2] - key[1][2] * key[2][0])
                    + key[0][2] * (key[1][0] * key[2][1] - key[1][1] * key[2][0]);
        } else {
            matrixValue = key[0][0] * key[1][1] - (key[1][0] * key[0][1]);
        }
        return (matrixValue % alpha.length() + alpha.length()) % alpha.length();
    }


    public static ArrayList<String> dividePlain(String plain, int key[][]) {
        plain = plain.replaceAll(" ", "");
        ArrayList<String> permutation = new ArrayList<>();
        if (plain.length() % key.length != 0) {
            int remain = key.length - plain.length() % key.length;
            plain += alpha.substring(0, remain);
        }

        for (int i = 0; i < plain.length(); i += key.length) {
            permutation.add(plain.substring(i, i + key.length));
        }

        return permutation;
    }

    public static int euclideanGcd(int a, int b) {

        if (b == 0)
            return a;
        int r = a % b;
        return euclideanGcd(b, r);
    }


}