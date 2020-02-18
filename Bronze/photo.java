import java.util.*;
import java.io.*;
public class photo {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("photo.in"));
        int N = in.nextInt();
        int[] grid = new int[N-1];
        int[] ans = new int[N];
        for (int z = 0; z < N-1; z++) grid[z] = in.nextInt();

        for (int z = 1; z < grid[0]; z++) {
            HashSet<Integer> visited = new HashSet();
            visited.add(z);
            ans[0] = z;
            int temp = grid[0]-z;
            visited.add(temp);
            ans[1] = temp;
            for (int a = 1; a < N-1; a++) {
                temp = grid[a]-temp;
                if (temp <= 0) break;
                if (visited.contains(temp)) break;
                visited.add(temp);
                ans[a+1] = temp;
            }
            if (visited.size() == N) break;
        }
        StringBuilder a = new StringBuilder();
        for (int z: ans) a.append(z + " ");
        a.deleteCharAt(a.length()-1);
        BufferedWriter out = new BufferedWriter(new FileWriter("photo.out"));
        out.write(a.toString() + "\n");
        System.out.println(a.toString());
        out.close();


    }
}
