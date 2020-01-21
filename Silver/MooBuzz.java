import java.util.*;
import java.io.*;

public class MooBuzz {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("moobuzz.in"));
        int N = in.nextInt();
        int ans = 0;
        int z = N;
        int upper = 2*N;
        int lower = 0;
        while (true) {
            int temp = z-z/3-z/5+z/15;
            if (N == temp) {
                ans = z;
                break;
            }
            else if (N < temp) {
                upper = z;
                z = (z+lower)/2;
            }
            else {
                lower = z;
                z += (upper-z)/2;
            }
        }
        while (true) {
            if (ans %3 == 0 || ans %5 == 0) ans--;
            else break;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("moobuzz.out"));
        out.write(ans + "\n");
        System.out.println(ans);
        out.close();
    }

}
