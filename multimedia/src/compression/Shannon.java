package compression;

import javax.swing.*;
import java.util.*;

/**
 * Created by mohamed on 12/21/2016.
 */
public class Shannon {
//    public static void main(String[] args) {
//        String out="";
//        String text = "acabadadeaabbaaaedcacdeaaabcdbbedcbacae";
//        int chars[] = new int[26];
//        HashMap<Character, Integer> charsMap = new HashMap<>();
//        for (int i = 0; i < text.length(); i++) {
//            ++chars[text.charAt(i) - 'a'];
//        }
//        for (int i = 0; i < chars.length; i++) {
//            int aChar = chars[i];
//            if (aChar > 0)
//                charsMap.put(Character.valueOf((char) ('a' + i)), aChar);
//        }
//
//
//        List<Map.Entry<Character, Integer>> characterInteger = sortHashMapByValues(charsMap);
//
//        HashMap<Character, String> result = new HashMap<>();
//        shanAlgor(result, characterInteger, "");
//        float befor = 0, after = 0;
//        for (Map.Entry<Character, Integer> charr : characterInteger) {
//            int beforCompression = charr.getValue() * 8;
//            int afterCompression = charr.getValue() * result.get(charr.getKey()).length();
//
//            befor += beforCompression;
//            after += afterCompression;
//      out+=beforCompression + "   " + afterCompression+"\n";
//            System.out.println(beforCompression + "   " + afterCompression);
//        }
//
//
//        System.out.println("Total # bits: "+befor + "  " + after);
//        System.out.println("compression ratio : "+ (befor / text.length()) + "  " + after / text.length());
//        out+="Total # bits: "+befor + "  " + after+"\n";
//        out+="compression ratio : "+ (befor / text.length()) + "  " + after / text.length()+"\n";
//        JOptionPane.showConfirmDialog(null,out);
//
//    }

    public Shannon(String text){
        String out="";
       // String text = "acabadadeaabbaaaedcacdeaaabcdbbedcbacae";
        int chars[] = new int[26];
        HashMap<Character, Integer> charsMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            ++chars[text.charAt(i) - 'a'];
        }
        for (int i = 0; i < chars.length; i++) {
            int aChar = chars[i];
            if (aChar > 0)
                charsMap.put(Character.valueOf((char) ('a' + i)), aChar);
        }


        List<Map.Entry<Character, Integer>> characterInteger = sortHashMapByValues(charsMap);

        HashMap<Character, String> result = new HashMap<>();
        shanAlgor(result, characterInteger, "");
        float befor = 0, after = 0;
        for (Map.Entry<Character, Integer> charr : characterInteger) {
            int beforCompression = charr.getValue() * 8;
            int afterCompression = charr.getValue() * result.get(charr.getKey()).length();

            befor += beforCompression;
            after += afterCompression;
            out+=beforCompression + "   " + afterCompression+"\n";
            System.out.println(beforCompression + "   " + afterCompression);
        }


        System.out.println("Total # bits: "+befor + "  " + after);
        System.out.println("compression ratio : "+ (befor / text.length()) + "  " + after / text.length());
        out+="Total # bits: "+befor + "  " + after+"\n";
        out+="compression ratio : "+ (befor / text.length()) + "  " + after / text.length()+"\n";
        JOptionPane.showConfirmDialog(null,out);
    }

    private static void shanAlgor(HashMap<Character, String> result, List<Map.Entry<Character, Integer>> characterIntegerLinkedHashMap, String bit) {
        if (characterIntegerLinkedHashMap.size() == 1) {
            result.put(characterIntegerLinkedHashMap.get(0).getKey(), bit);
            return;
        }

        int temp = 0;
        List<Map.Entry<Character, Integer>> finalSub1 = null;
        List<Map.Entry<Character, Integer>> finalSub2 = null;

        for (int i = 1; i < characterIntegerLinkedHashMap.size(); i++) {

            List<Map.Entry<Character, Integer>> sub1 = characterIntegerLinkedHashMap.subList(0, i);
            List<Map.Entry<Character, Integer>> sub2 = characterIntegerLinkedHashMap.subList(i, characterIntegerLinkedHashMap.size());
            int difference = Math.abs(subMapValue(sub1) - subMapValue(sub2));

            if (difference < temp || i == 1) {
                temp = difference;
                finalSub1 = sub1;
                finalSub2 = sub2;
            }


        }


        shanAlgor(result, finalSub1, bit + "0");
        shanAlgor(result, finalSub2, bit + "1");

    }

    public static int subMapValue(List<Map.Entry<Character, Integer>> sub) {
        int result = 0;
        for (Map.Entry<Character, Integer> row : sub) {

            result += row.getValue();
        }
        return result;
    }


    public static List<Map.Entry<Character, Integer>> sortHashMapByValues(
            HashMap<Character, Integer> passedMap) {
        List<Character> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<Character, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<Character> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Character key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }

        return entriesSortedByValues(sortedMap);
    }

    static List<Map.Entry<Character, Integer>> entriesSortedByValues(LinkedHashMap<Character, Integer> map) {

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());

        Collections.sort(sortedEntries,
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        return sortedEntries;
    }
}
