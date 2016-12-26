package company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by m7md on 22/10/16.
 */
public class Threshold {

//    public static void main(String[] args) throws IOException {
//
//
//        readBMP("src/camera.bmp");
//    }

    public static long bitSetToInt(BitSet bitSet) {
        long bitInteger = 0;
        for (int i = 0; i < 32; i++) {
//            System.out.print(bitSet.get(i) ? "1" : "0");
            if (bitSet.get(i))
                bitInteger |= (1 << i);
        }
//        System.out.println("");
        return bitInteger;

    }


    public String readBMP(String filename) throws IOException {
        int i;
        FileInputStream f = new FileInputStream(filename);
        byte info[] = new byte[54];
        f.read(info);
        System.out.println("Type : " + (char) info[0] + (char) info[1]);
        System.out.println("size : " + bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 2, 6))));

        long width = bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 18, 22)));
        long height = bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 22, 26)));

        System.out.println("Width : " + width);
        System.out.println("Height: " + height);


        long size = width * height;
        byte data[] = new byte[(int) size];

     String mFile="new_naran.bmp";
        FileOutputStream file = new FileOutputStream(mFile);
        file.write(info);
        int read = 0;

        for (i = 0; i < size; i++) {
            read = f.read();


            if (read >= 128) {
                file.write(255);
            } else {
                file.write(0);
            }

        }
        while ((read = f.read()) != -1) {
            file.write(read);
        }


        return mFile;

    }


}

