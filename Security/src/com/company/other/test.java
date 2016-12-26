package com.company.other;


import java.util.HashMap;
import java.util.Map;

/**
 * @author mohamed
 */
public class test {

    public static void main(String[] args) {
        HashMap<Integer, Integer> ab = new HashMap<>();
        HashMap<Integer, Integer> cd = new HashMap<>();

        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {


                if (((3 * a + 0 * b) % 26 == 3 && (21 * a + 4 * b) % 26 ==3)) {
                    ab.put(a, b);
                }

                if (((3 * a + 0* b) % 26 == 0 && (21 * a + 4 * b) % 26 == 12)) {
                    cd.put(a, b);
                }


            }

        }
        System.out.println();

    }


    public static void generate() {

    }

}

