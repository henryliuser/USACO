import java.util.Scanner;
import java.io.*;
public class fence {
    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(new File("paint.in"));
//        int a = in.nextInt();
//        int b = in.nextInt();
//        int c = in.nextInt();
//        int d = in.nextInt();
//        in.close();
        int a = 0, b= 100, c = 0, d = 100;

        int max, min;
        if (a < c) min = a;
        else min = c;
        if (b > d) max = b;
        else max = d;
        int[] grid = new int[max];

        for (int z = a; z < b; z++) {
            grid[z] = 1;
        }
        for (int p = c; p < d; p++) {
            grid[p] = 1;
        }
        int counter = 0;
        for (int z = 0; z < grid.length; z++) {
            if (grid[z] == 1) {
                counter++;
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("paint.out"));
//        String answer;
//        if ((c > a && c < b) || (a < d && a > c)) {
//            answer = (max-min) + "";
//            out.write(answer);
//        }
//        else if (a==c && b == d)
//        else {
//            answer = (b-a+d-c) + "";
//            out.write(answer);
//        }
//        System.out.println(answer);
        System.out.println(counter);
        out.write((counter) + "");
        out.close();


    }
}
