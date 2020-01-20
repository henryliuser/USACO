import java.util.*;
import java.io.*;
public class evolution {

    //global variables
    static String answer = "yes";
    static HashMap<Integer, HashSet<String>> log = new HashMap();
    static boolean done = false;


    static boolean debug = true;
    public static void main(String[] args) throws IOException {

        //input and initialization and calculate output
        String inpath = "evolution.in";
        if (debug) inpath = "/Users/henryliu/IdeaProjects/USACO/TextFiles/evolution.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        for (int z = 0; z < N; z++) {
            int a = in.nextInt();
            for (int b = 0; b < a; b++) {
                if (log.containsKey(a)) {
                    HashSet temp1 = log.get(a);
                    String temp2 = in.next();
                    if (temp1.contains(temp2)) {
                        done = true;
                        answer = "no";
                        break;
                    }
                    temp1.add(temp2);
                }
                else {
                    log.put(a, new HashSet<String>());
                    log.get(a).add(in.next());
                }
            }
            if (done) break;
            in.nextLine();
        }
        in.close();

        //write output
        BufferedWriter out = new BufferedWriter(new FileWriter("evolution.out"));
        out.write(answer);
        if (debug) System.out.println(answer);
        out.close();


    }

}
