package company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by m7md on 22/10/16.
 */
public class OrderedDithering {

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


    public String  readBMP(String filename) throws IOException {

        FileInputStream f = new FileInputStream(filename);
        byte info[] = new byte[54];

        short[][] threshold_map_4x4 = {
                {0, 128, 32, 160}
                , {192, 64, 224, 96}
                , {48, 176, 16, 144}
                , {240, 112, 208, 80}
        };
        String myfile="new_naran.bmp";
        FileOutputStream file = new FileOutputStream(myfile);


        f.read(info);
        file.write(info);


        System.out.println("Type : " + (char) info[0] + (char) info[1]);
        System.out.println("size : " + bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 2, 6))));

        int width = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 18, 22)));
        int height = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 22, 26)));

        System.out.println("Width : " + width);
        System.out.println("Height: " + height);


        short pixel = 0;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                pixel = (short) (f.read() > threshold_map_4x4[i % 4][j % 4] ? 255 : 0);
//                System.out.println(pixel);
                file.write(pixel);

            }

        }


        while ((pixel = (short) f.read()) != -1) {
            file.write(pixel);
        }

return  myfile;
    }


}

