//package train;

import java.util.*;
import java.io.*;

public class transform {

    static final String inpath = "transform.in";
    static final String outpath = "transform.out";
    static int size;
    static int[][] xGrid;

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader(inpath));
        size = Integer.parseInt(input.readLine());
        xGrid = new int [size][size];

        for (int c = 0; c <= size; c++) {

            for (int c1 = 0; c <= size; c++) {
                String currentLine = input.readLine();
                xGrid[c][c1]=Integer.parseInt(currentLine.substring(c1,c1 + 1));

            }

        }//end for

        System.out.println(xGrid);

    }//end main

}
