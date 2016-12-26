package compression;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;

import static company.OrderedDithering.bitSetToInt;

/**
 * Created by mohamed on 12/21/2016.
 */
public class RLE {
//    public static void main(String[] args) throws IOException {
//        FileInputStream file1 = new FileInputStream("src/camera.bmp");
//        String out="";
//      //  FileInputStream file1 = new FileInputStream(filename);
//        byte image1Info[] = new byte[54];
//        file1.read(image1Info);
//
//        int image1Width = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(image1Info, 18, 22)));
//        int image1Height = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(image1Info, 22, 26)));
//
////        int image1Size = image1Width * image1Height;
////        short image1data[][] = new short[image1Width][image1Height];
//        int prev =file1.read();
//        short counter = 1;
//        for (int i = 1; i < 30; ++i) {
//            int read = file1.read();
//            if (prev == read) {
//                ++counter;
//            } else {
//                if (i%5==0){
//                    out+="(" +(int) prev + "," + counter + "),\n";
//                }else{
//                out += ",(" + (int) prev + "," + counter + ")";
//            }
//
//
//                counter = 1;
//                prev = read;
//            }
//
//        }
//        JOptionPane.showConfirmDialog(null,out);
//        }



    public RLE(String filename) throws IOException {
        String out="";
        FileInputStream file1 = new FileInputStream(filename);
        byte image1Info[] = new byte[54];
        file1.read(image1Info);

        int image1Width = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(image1Info, 18, 22)));
        int image1Height = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(image1Info, 22, 26)));

//        int image1Size = image1Width * image1Height;
//        short image1data[][] = new short[image1Width][image1Height];
        int prev =file1.read();
        short counter = 1;
        for (int i = 1; i < 40; ++i) {
            int read = file1.read();
            if (prev == read) {
                ++counter;
            } else {
                if (i%5==0){
                    out+="(" +(int) prev + "," + counter + "),\n";
                }else{
                    out+=",(" +(int) prev + "," + counter + ")";

                }

                counter = 1;
                prev = read;
            }

        }
        JOptionPane.showConfirmDialog(null,out);
    }
}
