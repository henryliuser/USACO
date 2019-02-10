import java.util.*;
import java.io.*;
public class crosswords {
    static boolean debug = false;

//    static class Space {
//        boolean isBlocked;
//
//        public Space(boolean a) {
//            isBlocked = a;
//        }
//    }

    public static void main(String[] args) throws IOException {
        String inpath = "crosswords.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/TextFiles/crosswords.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine(); //erghjkl
        char[][] grid = new char[N][M];
        for (int z = 0; z < N; z++) {
            String row = in.nextLine();
            for (int c = 0; c < M; c++) {
                grid[z][c] = row.charAt(c);
            }
        }
        ArrayList<int[]> answers = new ArrayList();
        for (int z = 0; z < N; z++) {
            for (int c = 0; c < M; c++) {
                boolean horizontal = true, vertical = true;
                char current = grid[z][c];
                if (current == '#') continue;
                try {
                    if ( !(c-1 < 0 || grid[z][c-1] == '#') ) horizontal = false;
                    if ( !(grid[z][c+1] == '.' && grid[z][c+2] == '.') ) horizontal = false;
                }
                catch (ArrayIndexOutOfBoundsException e) {horizontal = false;}
                try {
                    if ( !(z-1 < 0 || grid[z-1][c] == '#') ) vertical = false;
                    if ( !(grid[z+1][c] == '.' && grid[z+2][c] == '.') ) vertical = false;
                }
                catch (ArrayIndexOutOfBoundsException e) {vertical = false;}

                if (vertical || horizontal) answers.add(new int[]{z+1,c+1});
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("crosswords.out"));
        out.write(answers.size() + "\n");
        for (int[] x: answers) {
            String ans = (x[0] + " " + x[1] + "\n");
            out.write(ans);
            System.out.print(ans);
        }
        out.close();

    }
}
