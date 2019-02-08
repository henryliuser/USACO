import java.util.Scanner;
import java.io.*;
public class outofplace {

    static boolean debug = false;

    public static void main(String[] args) throws IOException {

        String inpath = "Text Files/outofplace.in";
        if (debug) inpath = "/Users/henry/Desktop/projects/USACO/Bronze/outofplace.in";
        Scanner in = new Scanner(new File(inpath));

        int N = in.nextInt();           //read the order of cows into list[]
        int[] list = new int[N];
        int answer = 1;
        for (int z = 0; z < N; z++) {
            list[z] = in.nextInt();
            if (z > 1) {
                if (list[z] > list[z-1]) {
                    answer++;
                }
                else if (list[z] == list[z-1]);
                else break;
            }

        }
        in.close();

        System.out.println(answer);
        BufferedWriter out = new BufferedWriter(new FileWriter("outofplace.out"));
        out.write(answer + "");
        out.close();







    }
}
