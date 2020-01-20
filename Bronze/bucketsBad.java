import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class bucketsBad {

    //important variables
    static char[][] grid = new char[10][10]; //store the grid
    static int barnX, barnY; //store coordinates of barn
    static int lakeX, lakeY; //store coordinates of lake
    static int globalMin; //store the minimum number of cows (answer)

    static boolean debug = true;
    public static void main(String[] args) throws IOException {

        //read and store grid
        String inpath = "buckets.in";
        if (debug) inpath = "/Users/henryliu/IdeaProjects/USACO/TextFiles/buckets.in";
        BufferedReader input = new BufferedReader(new FileReader("/Users/henryliu/IdeaProjects/USACO/TextFiles/bucketsBad.in"));
        for (int x = 0; x < 10; x++) {
            String line = input.readLine();
            for (int index = 0; index < 10; index++) {
                char a = line.charAt(index);
                if (a == 'B') {barnX = index; barnY = x;} //set coordinates
                if (a == 'L') {lakeX = index; lakeY = x;} //set coordinates
                grid[x][index] = line.charAt(index);
            }
        }
        input.close();

        //calculate output
        search(lakeX, lakeY, 0,new HashSet());

        //write output
        BufferedWriter output = new BufferedWriter(new FileWriter("bucketsBad.out"));
        output.write(globalMin + "");
        System.out.println(globalMin);
        output.close();


    }

    static int[] edgeCheck(int x, int y) {
        int[] validNext = new int[4];
        //up = 0	right = 1	 down = 2	left = 3
        if (x>0 && grid[x-1][y] != 'R') validNext[3] = -1;
        if (x<9 && grid[x+1][y] != 'R') validNext[1] = 1;
        if (y>0 && grid[x][y-1] != 'R') validNext[0] = -1;
        if (y<9 && grid[x][y+1] != 'R') validNext[2] = 1;
        return validNext;
    }

    static int[] axisAlign(int x, int y) {
        int[] aligns = new int[2];
        if (x - barnX > 0) aligns[0] = 3; else if (x - barnX < 0) aligns[0] = 1; else aligns[0] = 5;
        if (y - barnY > 0) aligns[1] = 0; else if (y - barnY < 0) aligns[1] = 2; else aligns[1] = 5;
        return aligns;
    }

    static int opposite(int x) {
        if (x == 1) return 3;
        if (x == 3) return 1;
        if (x == 0) return 2;
        if (x == 2) return 0;
        return -1;
    }

    //check if visited previously
    public static boolean prior(int[] coo, HashSet a) {
        if (a.contains(coo)) return true;
        else {
            a.add(coo);
            return false;
        }
    }

    //recursively simulates minimum path, aligns one axis at a time
    public static void search(int x, int y, int counter, HashSet visited) {
        HashSet<int[]> a = (HashSet)visited.clone();

        if (x == barnX && y == barnY) {
            globalMin = Math.min(globalMin, counter-1);
            return;
        }
        int[] validNext = edgeCheck(x,y);
        int[] aligns = axisAlign(x,y);
        int[] opposites = new int[2];
        opposites[1] = opposite(aligns[1]);
        opposites[0] = opposite(aligns[0]);
        int[] temp = null;

        if ( (validNext[aligns[0]]!=0)) {
            temp = new int[]{x +validNext[aligns[0]],y};
            if (!prior(temp,a))
                search(temp[0],temp[1],counter+1,a);
        }
        if ( (validNext[aligns[1]]!=0)) {
            temp = new int[]{x, y+validNext[aligns[1]]};
            if (!prior(temp,a))
                search(temp[0],temp[1],counter+1,a);
        }
        if ( (validNext[opposites[1]]!=0)) {
            temp = new int[]{x,y + validNext[opposites[1]]};
            if (!prior(temp, a))
                search(temp[0],temp[1],counter+1,a);
        }
        if ( (validNext[opposites[0]]!=0)) {
            temp = new int[]{x + validNext[opposites[0]],y};
            if (!prior(temp, a))
                search(temp[0],temp[1],counter+1,a);
        }

    }


}