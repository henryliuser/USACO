import java.util.*;
import java.io.*;
public class whereami {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("whereami.in"));
        int N = in.nextInt();
        String str = in.next();
        int currK = 0;
        HashSet<String> currSet = new HashSet();
        boolean done = false;
        while (!done) {
            currK++;
            for (int z = 0; z < N-currK+1; z++) {
                String temp = str.substring(z, z+ currK);
                if (currSet.contains(temp)) {
                    break;
                }
                currSet.add(temp);
                if (z == N-currK) {
                    done = true;
                    break;
                }
            }
            if (done) break;
            else currSet = new HashSet();
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("whereami.out"));
        out.write(currK + "\n");
        System.out.println(currK);
        out.close();

    }

}
