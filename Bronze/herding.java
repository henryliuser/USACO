import java.util.*;
import java.io.*;
public class herding {
    static boolean debug = false;
    public static void main(String[] args) throws IOException {
        String inpath = "herding.in";
        if (debug) inpath = "/Users/henryliu/IdeaProjects/USACO/TextFiles/herding.in";
        Scanner in = new Scanner(new File(inpath));
        int[] grid = new int[3];
        for (int z = 0; z < 3; z++) {
            grid[z] = in.nextInt();
        }
        Arrays.sort(grid);
        int gap1 = grid[1]-grid[0], gap2 = grid[2]-grid[1];
        BufferedWriter out = new BufferedWriter(new FileWriter("herding.out"));
        if (gap1 == 2 || gap2 == 2)
            out.write("1\n");
        else
            out.write("2\n");

        out.write(Math.max(gap1,gap2)-1 + "\n");
        out.close();


    }
}
