import java.util.*;
import java.io.*;
public class word {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("word.in"));
        int N = in.nextInt();
        int K = in.nextInt();
        StringBuilder ans = new StringBuilder();
        int charCount = 0;
        for (int z = 0; z < N; z++) {
            String temp = in.next();
            if (temp.length() + charCount <= K) {
                ans.append(temp + " ");
                charCount += temp.length();
            }
            else {
                ans.deleteCharAt(ans.length()-1);
                ans.append("\n" + temp + " ");
                charCount = temp.length();
            }
        }
        ans.deleteCharAt(ans.length()-1);
        BufferedWriter out = new BufferedWriter(new FileWriter("word.out"));
        out.write(ans.toString());
        out.close();
    }
}
