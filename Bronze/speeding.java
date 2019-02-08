import java.util.Scanner;
import java.io.*;
public class speeding {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("speeding.in"));
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] segments = new int[N][2];
        int[][] routes = new int[M][2];
        for (int z = 0; z < N; z++) {
            segments[z][0] = in.nextInt();
            segments[z][1] = in.nextInt();
        }
        for (int z = 0; z < M; z++) {
            routes[z][0] = in.nextInt();
            routes[z][1] = in.nextInt();
        }
        in.close();

        int[][] grid = new int[100][2];
        int position = 0;
        for (int b = 0; b < N; b++) {
            int[] x = segments[b];
            for (int z = position; z < position + x[0]; z++) {
                grid[z][0] = x[1];
//                System.out.print(z + "/" + x[1] + " ");
            }
            position += x[0];
        }
        position = 0;
        for (int b = 0; b < M; b++) {
            int[] x = routes[b];
            for (int z = position; z < position + x[0]; z++) {
                grid[z][1] = x[1];
//                System.out.print(z + "/" + x[1] + " ");
            }
            position += x[0];
        }

        int answer = 0;
        for (int z = 0; z < 100; z++) {
            int diff = (grid[z][1] - grid[z][0]);
            if (diff > answer) {
                System.out.println(z+" "+diff+" "+answer);
                answer = diff;
            }
        }
        System.out.println(answer);
        BufferedWriter out = new BufferedWriter(new FileWriter("speeding.out"));
        out.write(answer + "");
        out.close();

    }
}
