package compression;

/**
 * Created by m7md on 22/12/16.
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mohamed on 12/21/2016.
 */
public class Huffman {
    public static String out = "";
//    public static void main(String[] args) {
//        String text = "bbblleeiatsn";
//        int chars[] = new int[26];
////        HashMap<Node, Integer> charsMap = new HashMap<>();
//        List<Map.Entry<Node, Integer>> charsMap = new ArrayList<>();
//       /* for (int i = 0; i < text.length(); i++) {
//            ++chars[text.charAt(i) - 'a'];
//        }
//        for (int i = 0; i < chars.length; i++) {
//            int aChar = chars[i];
//            if (aChar > 0) {
//                HashMap<Node, Integer> sub = new HashMap<>();
//                sub.put(java.lang.Node.valueOf((char) ('a' + i)), aChar);
//                charsMap.add(sub.entrySet().iterator().next());
//
//            }
//
//        }*/
//        HashMap<Node, Integer> sub = new HashMap<>();
//        sub.put(new Node(0, "b"), 3);
//        charsMap.add(sub.entrySet().iterator().next());
//
//        sub = new HashMap<>();
//        sub.put(new Node(0, "i"), 1);
//        charsMap.add(sub.entrySet().iterator().next());
//
//        sub = new HashMap<>();
//        sub.put(new Node(0, "l"), 2);
//        charsMap.add(sub.entrySet().iterator().next());
//
//        sub = new HashMap<>();
//        sub.put(new Node(0, "e"), 2);
//        charsMap.add(sub.entrySet().iterator().next());
//
//        sub = new HashMap<>();
//        sub.put(new Node(0, "a"), 1);
//        charsMap.add(sub.entrySet().iterator().next());
//
//        sub = new HashMap<>();
//        sub.put(new Node(0, "t"), 1);
//        charsMap.add(sub.entrySet().iterator().next());
//
//        sub = new HashMap<>();
//        sub.put(new Node(0, "s"), 1);
//        charsMap.add(sub.entrySet().iterator().next());
//
//        sub = new HashMap<>();
//        sub.put(new Node(0, "n"), 1);
//        charsMap.add(sub.entrySet().iterator().next());
//
//
//        sortHashMap(charsMap);
//
//        ArrayList<Node> result = new ArrayList<>();
//        huffman(result, charsMap);
//
//        printTree(result.get(0),"");
//        JOptionPane.showConfirmDialog(null,out);
//
//    }

    public Huffman(String text) {
        int chars[] = new int[26];
//        HashMap<Node, Integer> charsMap = new HashMap<>();
        List<Map.Entry<Node, Integer>> charsMap = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            ++chars[text.charAt(i) - 'a'];
        }
        for (int i = 0; i < chars.length; i++) {
            int aChar = chars[i];
            if (aChar > 0) {
                HashMap<Node, Integer> sub = new HashMap<>();

                sub.put(new Node(0, (char) ('a' + i) + ""), aChar);
                charsMap.add(sub.entrySet().iterator().next());

            }

        }



/*

        HashMap<Node, Integer> sub = new HashMap<>();
        sub.put(new Node(0, "b"), 3);
        charsMap.add(sub.entrySet().iterator().next());

        sub = new HashMap<>();
        sub.put(new Node(0, "i"), 1);
        charsMap.add(sub.entrySet().iterator().next());

        sub = new HashMap<>();
        sub.put(new Node(0, "l"), 2);
        charsMap.add(sub.entrySet().iterator().next());

        sub = new HashMap<>();
        sub.put(new Node(0, "e"), 2);
        charsMap.add(sub.entrySet().iterator().next());

        sub = new HashMap<>();
        sub.put(new Node(0, "a"), 1);
        charsMap.add(sub.entrySet().iterator().next());

        sub = new HashMap<>();
        sub.put(new Node(0, "t"), 1);
        charsMap.add(sub.entrySet().iterator().next());

        sub = new HashMap<>();
        sub.put(new Node(0, "s"), 1);
        charsMap.add(sub.entrySet().iterator().next());

        sub = new HashMap<>();
        sub.put(new Node(0, "n"), 1);
        charsMap.add(sub.entrySet().iterator().next());

*/

        sortHashMap(charsMap);

        ArrayList<Node> result = new ArrayList<>();
        huffman(result, charsMap);

        printTree(result.get(0), "");
        JOptionPane.showConfirmDialog(null, out);
    }


    static void printTree(Node node, String bit) {

        if (node.left == null) {
            out += node.value + "   " + bit + "\n";
            System.out.println(node.value + " " + bit);
            return;
        }

        if (node.right == null) {
            out += node.value + "   " + bit + "\n";
            System.out.println(node.value + " " + bit);
            return;
        }
        printTree(node.left, bit + node.left.sign);
        printTree(node.right, bit + node.right.sign);


    }

    private static void sortHashMap(List<Map.Entry<Node, Integer>> charsMap) {


        int j;
        boolean flag = true;   // set flag to true to begin first pass
        Map.Entry<Node, Integer> temp;   //holding variable

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

    private static void huffman(ArrayList<Node> result, List<Map.Entry<Node, Integer>> data) {
        if (data.size() <2) {
            return;
        }
        List<Map.Entry<Node, Integer>> newChars = new ArrayList<>();

        Map.Entry<Node, Integer> last = data.get(data.size() - 1);
        Map.Entry<Node, Integer> beforeLast = data.get(data.size() - 2);

        int sum = beforeLast.getValue() + last.getValue();
        String subStr = beforeLast.getKey().value + last.getKey().value;
        Node node = new Node(0, subStr);
        beforeLast.getKey().sign = 0;
        last.getKey().sign = 1;
        node.left = beforeLast.getKey();
        node.right = last.getKey();


        boolean flag = false;
        for (int i = 0; i < data.size() - 2; ++i) {
            if (data.get(i).getValue() <= sum && flag == false) {
                HashMap<Node, Integer> sub = new HashMap<>();
                sub.put(node, sum);
                newChars.add(sub.entrySet().iterator().next());
                newChars.add(data.get(i));
                flag = true;
            } else {
                newChars.add(data.get(i));
            }


        }
        if (data.size() == 2)
            result.add(node);

        huffman(result, newChars);

    }

 /*   public static int subMapValue(List<Map.Entry<Node, Integer>> sub) {
        int result = 0;
        for (Map.Entry<Node, Integer> row : sub) {

            result += row.getValue();
        }
        return result;
    }*/

}


class Node {
    int sign;
    String value;
    Node left;
    Node right;

    public Node(int sign, String value) {
        this.sign = sign;
        this.value = value;
    }
}
