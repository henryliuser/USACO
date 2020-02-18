import java.util.*;
import java.io.*;
public class race {

    public static int add(int d, int a) {
        int ans = 0;
        for (int z = d; z <= a; z++) ans += z;
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("race.in"));
        int K = in.nextInt();
        int N = in.nextInt();

        int[] ans = new int[N];
        for (int z = 0; z < N; z++) {
            int X = in.nextInt();

            int minDistLeft = 0;
            int distLeft = K;
            int currSpd = 0;
            int time = 0;
            while (true) {
                time++;
                currSpd++;
                if (currSpd > X) {
                    minDistLeft = add(X, currSpd);
                    if (minDistLeft > distLeft) {
                        currSpd--;
                        minDistLeft = add(X, currSpd);
                        if (minDistLeft > distLeft) currSpd--;
                    }
                }
                distLeft -= currSpd;
                if (distLeft <= 0) break;

            ans[z] = time;
            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter("race.out"));
        for (int z: ans) {
            System.out.println(z);
            out.write(z + "\n");
        }
        out.close();

    }
}
