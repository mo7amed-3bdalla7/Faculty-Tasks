package company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by m7md on 22/10/16.
 */
public class Floyed {

//    public static void main(String[] args) throws IOException {
//
//
//        readBMP("src/sample/camera.bmp");
//    }

    public long bitSetToInt(BitSet bitSet) {
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

        FileInputStream f = new FileInputStream(filename);
        byte info[] = new byte[54];
        f.read(info);
        System.out.println("Type : " + (char) info[0] + (char) info[1]);
        System.out.println("size : " + bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 2, 6))));

        int width = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 18, 22)));
        int height = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 22, 26)));

        System.out.println("Width : " + width);
        System.out.println("Height: " + height);


        int size = width * height, prev = 0, error = 0;
        short data[][] = new short[width][height];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                data[i][j] = (short) f.read();
            }

        }
        String outFile = "out.bmp";
        FileOutputStream file = new FileOutputStream(outFile);
        file.write(info);
        int pixel = 0;


        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                prev = data[i][j];
                if (data[i][j] >= 128)
                    data[i][j] = 255;
                else
                    data[i][j] = 0;

                error = prev - data[i][j];
                if (i < height - 1)
                    data[i + 1][j] = (short) Math.ceil(data[i + 1][j] + (double) error * 7 / 16);
                if (i > 0 && j < width - 1)
                    data[i - 1][j + 1] = (short) Math.ceil(data[i - 1][j + 1] + (double) error * 3 / 16);
                if (j < width - 1)
                    data[i][j + 1] = (short) Math.ceil(data[i][j + 1] + (double) error * 5 / 16);
                if (i < height - 1 && j < width - 1)
                    data[i + 1][j + 1] = (short) Math.ceil(data[i + 1][j + 1] + (double) error * 1 / 16);
                file.write(data[i][j]);

            }

        }


        while ((pixel = f.read()) != -1) {
            file.write(pixel);
        }


        return outFile;
    }

}

