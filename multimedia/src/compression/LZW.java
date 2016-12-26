package compression;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by mohamed on 12/23/2016.
 */
public class LZW {
   public static String out="";
//    public static void main(String[] args) {
//        HashMap<String, Integer> table = new HashMap<>();
//        for (char c = 'A'; c <= 'z'; ++c) {
//            table.put(c + "", (int) c);
//        }
//        String text = "BABAABAaaaAA";
//
//        int index = 256;
//        String p = text.charAt(0) + "";
//        for (int i = 1; i < text.length(); ++i) {
//            String c = text.charAt(i) + "";
//            String pc = p + c;
//            if (table.get(pc) != null) {
//                p = pc;
//            } else {
//              //  System.out.println(table.get(p));
//                out+=table.get(p)+"\n";
//                table.put(pc, index++);
//                p=c;
//            }
//        }
//        out+=table.get(p)+"\n";
////        if (!out.isEmpty()) {
////            out.replace(null, "");
////        }
//        //System.out.println(table.get(p));
//        JOptionPane.showConfirmDialog(null,out);
//
//    }

    public LZW(String text){
        HashMap<String, Integer> table = new HashMap<>();
        for (char c = 'A'; c <= 'z'; ++c) {
            table.put(c + "", (int) c);
        }
        int index = 256;
        String p = text.charAt(0) + "";
        for (int i = 1; i < text.length(); ++i) {
            String c = text.charAt(i) + "";
            String pc = p + c;
            if (table.get(pc) != null) {
                p = pc;
            } else {
                //  System.out.println(table.get(p));
                out+=table.get(p)+"\n";
                table.put(pc, index++);
                p=c;
            }
        }
        out+=table.get(p)+"\n";
//        if (!out.isEmpty()) {
//            out.replace(null, "");
//        }
        //System.out.println(table.get(p));
        JOptionPane.showConfirmDialog(null,out);

    }

}
