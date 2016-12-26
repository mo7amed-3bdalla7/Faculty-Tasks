package com.company.other;

/**
 * Created by m7md on 26/11/16.
 */
public class Combination {
    //    public static char matrix[][] = new char[5][5];
    public static String plain = "we like football";
    public static String text = "abcdefghijklmnopqrstuvwxy";

    public static void main(String[] args) {
        String part1, part2;
        plain = plain.replaceAll(" ", "");
        plain = plain.replaceAll("z", "q");

    /*    char alpha = 'a';
        for (int i = 0; i < 25; ++i) {
            matrix[i / 5][i % 5] = alpha++;
        }
*/

        String result = "";

        for (int i = 0; i < plain.length(); i++) {
            int index = text.indexOf(plain.charAt(i));
            result += text.charAt(index / 5);
            result += text.charAt(index % 5);
        }

        part1 = result.substring(0, result.length() / 2);
        part2 = result.substring(result.length() / 2);

        String cipher = "";
        for (int i = 0; i < part1.length(); i++) {
            int row = text.indexOf(part1.charAt(i)) * 5;
            int col = text.indexOf(part2.charAt(i));

            cipher += text.charAt(row + col);
        }
        System.out.println(cipher);

    }
}
