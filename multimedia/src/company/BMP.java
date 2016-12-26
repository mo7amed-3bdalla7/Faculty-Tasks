package company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;

public class BMP {


    public  String bitSetToInt(String path) throws IOException {
            String out="";
        byte[] buffer = new byte[4];
        byte[] sig = new byte[2];
        FileInputStream is = new FileInputStream(path);
        FileInputStream f = new FileInputStream(path);
        byte info[] = new byte[54];
        f.read(info);
//        System.out.println("Type : " + (char) info[0] + (char) info[1]);
//        System.out.println("size : " + bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 2, 6))));
        out+="Type : " + (char) info[0] + (char) info[1]+"\n";
        out+="size : " + bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 2, 6)))+"\n";
        int width = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 18, 22)));
        int height = (int) bitSetToInt(BitSet.valueOf(Arrays.copyOfRange(info, 22, 26)));
        out+="width :"+width+"\n";
        out+="height :"+height;
        return out;

    }

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

}
