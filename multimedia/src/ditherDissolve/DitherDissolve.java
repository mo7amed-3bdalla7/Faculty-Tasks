package ditherDissolve;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by m7md on 20/12/16.
 */
public class DitherDissolve {
//    public static void main(String[] args) throws IOException, InterruptedException {
//        new Gui();
//        readBMP("src/lena.bmp", "src/camera.bmp", 2.0F);
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

    public static byte[] extractBytes(String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        return (data.getData());
    }

    public static byte[] bufferedImageToByteArray(String image) throws IOException {

        File fi = new File(image);
        byte[] fileContent = Files.readAllBytes(fi.toPath());
        return fileContent;
    }

    public void readBMP(String image1, String image2, float alpha) throws IOException, InterruptedException {
        byte[] imageBytes = extractBytes(image1);

        FileInputStream file1 = new FileInputStream(image1);
        byte image1Info[] = new byte[54];
        file1.read(image1Info);

        int image1Width = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(image1Info, 18, 22)));
        int image1Height = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(image1Info, 22, 26)));

//        int image1Size = image1Width * image1Height;
        short image1data[][] = new short[image1Width][image1Height];

        for (int i = 0; i < image1Height; ++i) {
            for (int j = 0; j < image1Width; ++j) {
                image1data[i][j] = (short) file1.read();
            }

        }


        FileInputStream file2 = new FileInputStream(image2);
        byte image2Info[] = new byte[54];
        file2.read(image2Info);

        int image2Width = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(image2Info, 18, 22)));
        int image2Height = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(image2Info, 22, 26)));

//        int image2Size = image2Width * image2Height;
        short image2data[][] = new short[image2Width][image2Height];

        for (int i = 0; i < image2Height; ++i) {
            for (int j = 0; j < image2Width; ++j) {
                image2data[i][j] = (short) file2.read();
            }

        }


//        byte newImage[][] = new byte[image1Height][image1Width];

        int height = image2Height > image1Height ? image2Height : image1Height;
        int width = image2Width > image1Width ? image2Width : image1Width;

        byte[] image1Bytes = bufferedImageToByteArray(image1);
        byte[] image2Bytes = bufferedImageToByteArray(image2);

        for(int i=0;i<54;i++){
            image2Bytes[i]=image1Info[i];
        }
        int index =1024;
        int it = (int) (height/alpha);
        for (int x = 0; x < height; x += it) {
            // for (int i = x; i < (((i + it) >= height) ? height : (i + it)); ++i) {
            for (int j = 0; j < it * width && (index <= width * height); ++j) {
                image2Bytes[index++] = image1Bytes[index];
            }
            //   }
            FileOutputStream file = new FileOutputStream("src/ditherDissolve/new.bmp");
            file.write(image2Bytes);
            file.close();
            Image image = ImageIO.read(new File("src/ditherDissolve/new.bmp"));
            ImageIcon icon = new ImageIcon(image);
            Gui.imgeLabel.setIcon(icon);
            Thread.sleep(1000);

            if (x < height-it) {
                PrintWriter writer = new PrintWriter("src/ditherDissolve/new.bmp");
                writer.print("");
                writer.close();
            }
        }


    }

}
