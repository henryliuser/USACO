import java.util.*;
import java.io.*;

public class buckets {
    //important variables
    static char[][] grid = new char[10][10]; //store the grid
    static int barnX, barnY; //store coordinates of barn
    static int lakeX, lakeY; //store coordinates of lake
    static int rockX, rockY; //rock

    static boolean debug = true;
    public static void main(String[] args) throws IOException {
        String inpath = "buckets.in";
        if (debug) inpath = "/Users/henryliu/IdeaProjects/USACO/TextFiles/buckets.in";
        BufferedReader input = new BufferedReader(new FileReader(inpath));
        for (int x = 0; x < 10; x++) {
            String line = input.readLine();
            for (int index = 0; index < 10; index++) {
                char a = line.charAt(index);
                if (a == 'B') {barnX = index; barnY = x;} //set coordinates
                if (a == 'L') {lakeX = index; lakeY = x;} //set coordinates
                if (a == 'R') {rockX = index; rockY = x;} //set coordinates
                grid[x][index] = line.charAt(index);
            }
        }
        input.close();

        int distance = Math.abs(barnX - lakeX) + Math.abs(barnY - lakeY);
        if (barnX == lakeX && lakeX == rockX) {
            if (lakeY < barnY && rockY > lakeY && rockY < barnY) distance += 2;
            else if (lakeY > barnY && rockY < lakeY && rockY > barnY) distance += 2;
        }
        if (barnY == lakeY && lakeY == rockY) {
            if (lakeX < barnX && rockX > lakeX && rockX < barnX) distance += 2;
            else if (lakeX > barnX && rockX < lakeX && rockX > barnX) distance += 2;
        }
        distance -= 1;
        BufferedWriter output = new BufferedWriter(new FileWriter("buckets.out"));
        output.write(distance + "");
        System.out.println(distance);
        output.close();


    }
}