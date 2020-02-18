import java.util.*;
import java.io.*;
public class berries {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("berries.in"));
        int N = in.nextInt();
        int K = in.nextInt();
        Integer[] arr = new Integer[N];
        for (int z = 0; z < N; z++) arr[z] = in.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());



        int ans = -1;
        for (int z = 1; ;z++) {
            int bounter = 0;
            Integer[] temp = arr.clone();
            int[] curr = new int[K];
            for (int a = 0; a < K; a++) {
                if (temp[bounter] >= z) {
                    temp[bounter] -= z;
                    curr[a] += z;
                }
                else {
                    bounter++;
                    a--;
                    if (bounter == K) {
                        Arrays.sort(temp, Collections.reverseOrder());
                        int qwqetr = 0;
                        for (int b = a; b < K; b++) curr[b] = temp[qwqetr++];
                        break;
                    }
                }
            }
            int sum = 0;
            for (int b = K/2; b < K; b++) sum+=curr[b];
            if (sum > ans) ans = sum;
            else break;

        }

        BufferedWriter out = new BufferedWriter(new FileWriter("berries.out"));
        out.write(ans + "\n");
        out.close();


    }
}
