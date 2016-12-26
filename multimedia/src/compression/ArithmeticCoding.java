package compression;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mohamed on 12/23/2016.
 */
public class ArithmeticCoding {
//    public static void main(String[] args) {
//        String text = "aaf";
//        int chars[] = new int[26];
//        for (int i = 0; i < text.length(); ++i) {
//            ++chars[text.charAt(i) - 'a'];
//        }
//        List<Map.Entry<String, Float>> charsMap = new ArrayList<>();
//
//        for (int i = 0; i < chars.length; i++) {
//            int aChar = chars[i];
//            if (aChar > 0) {
//                HashMap<String, Float> sub = new HashMap<>();
//                char c = (char) (i + 'a');
//                sub.put(c + "", (float) aChar / text.length());
//                charsMap.add(sub.entrySet().iterator().next());
//
//            }
//        }
//
//        sortHashMap(charsMap);
//        HashMap<String, HashMap<Float, Float>> probabilities = getPropabilities(charsMap);
//        arithmeticCode(text, probabilities);
//
//        System.out.println();
//
//    }
    public ArithmeticCoding(String text){
        int chars[] = new int[26];
        for (int i = 0; i < text.length(); ++i) {
            ++chars[text.charAt(i) - 'a'];
        }
        List<Map.Entry<String, Float>> charsMap = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            int aChar = chars[i];
            if (aChar > 0) {
                HashMap<String, Float> sub = new HashMap<>();
                char c = (char) (i + 'a');
                sub.put(c + "", (float) aChar / text.length());
                charsMap.add(sub.entrySet().iterator().next());

            }
        }

        sortHashMap(charsMap);
        HashMap<String, HashMap<Float, Float>> probabilities = getPropabilities(charsMap);
        arithmeticCode(text, probabilities);

        System.out.println();
    }

    public static void arithmeticCode(String text, HashMap<String, HashMap<Float, Float>> probabilities) {
        double high = 1.0;
        double low = 0.0;
        for (int i = 0; i < text.length(); ++i) {
            String c = text.charAt(i)+"";
            HashMap<Float, Float> p = probabilities.get(c);
//            System.out.println(p);
            Map.Entry<Float, Float> next = p.entrySet().iterator().next();
            double range = high - low;
            high = low + range * next.getValue();
            low = low + range * next.getKey();
        }
        JOptionPane.showConfirmDialog(null,low + (high - low) / 2);
       // System.out.println("ddddddddd"+low + (high - low) / 2);
    }

    private static HashMap<String, HashMap<Float, Float>> getPropabilities(List<Map.Entry<String, Float>> charsMap) {
        float temp = 0;
        HashMap<String, HashMap<Float, Float>> result = new HashMap<>();
        for (Map.Entry<String, Float> entry : charsMap) {
            HashMap<Float, Float> pair = new HashMap<>();
            pair.put(temp, temp + entry.getValue());
            result.put(entry.getKey(), pair);
            temp += entry.getValue();
        }

        return result;


    }

    private static void sortHashMap(List<Map.Entry<String, Float>> charsMap) {


        int j;
        boolean flag = true;   // set flag to true to begin first pass
        Map.Entry<String, Float> temp;   //holding variable

        while (flag) {
            flag = false;    //set flag to false awaiting a possible swap
            for (j = 0; j < charsMap.size() - 1; j++) {
                if (charsMap.get(j).getValue() < charsMap.get(j + 1).getValue())   // change to > for ascending sort
                {
                    temp = charsMap.get(j);                //swap elements
                    charsMap.add(j, charsMap.get(j + 1));
                    charsMap.remove(j + 1);
                    charsMap.add(j + 1, temp);
                    charsMap.remove(j + 2);
                    flag = true;              //shows a swap occurred
                }
            }
        }

        System.out.println();


    }

}
