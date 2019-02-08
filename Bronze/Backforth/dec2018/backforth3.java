package Backforth.dec2018;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class backforth3 {



    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String inputFile = "/Users/henry/Desktop/projects/USACO/Bronze/backforth.in";


        BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(inputFile), "UTF-8"));
        String line;
        line = reader.readLine();
        String[] aBuckets =  line.split("[ \t]+");

        int[] aIntBucket = new int[10];
        for (int i=0;i<10; i++) {
            aIntBucket[i] = Integer.parseInt(aBuckets[i]);
        }

        line = reader.readLine();
        String[] bBuckets =  line.split("[ \t]+");
        int[] bIntBucket = new int[11];
        for (int i=0;i<11; i++) {
            if (i != 10) {
                bIntBucket[i] = Integer.parseInt(bBuckets[i]);
            } else {
                bIntBucket[i] = 0;
            }
        }


        HashSet<Integer> readings = new HashSet<>();
        int reading=1000;
        for (int i=0;i<10;i++) {
            for (int j=0; j<10; j++) {
                bIntBucket[10] = aIntBucket[i];
                reading -= aIntBucket[i];
                aIntBucket[i] = bIntBucket[j];
                reading += bIntBucket[j];

                for (int i1=0; i1< 10; i1++) {
                    for (int j1=0; j1<11; j1++ ) {
                        if (j1 == j)  continue;
                        bIntBucket[j] = aIntBucket[i1];
                        reading -= aIntBucket[i1];
                        aIntBucket[i1] = bIntBucket[j1];
                        reading += bIntBucket[j1];
                        readings.add(reading);
                    }
                }
            }
        }

        System.out.println(readings.toString());
    }

}