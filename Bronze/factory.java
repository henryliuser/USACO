import java.util.*;
import java.io.*;
public class factory {

    static class Station {
        ArrayList<Station> from = new ArrayList();
        int num;
        public Station(int num) {
            this.num = num;
        }
    }

    //global variables
    static Station[] list;
    static int answer = -1;


    static boolean debug = false;
    public static void main(String[] args) throws IOException {

        //read input and initialize data
        String inpath = "factory.in";
        if (debug) inpath = "/Users/henryliu/IdeaProjects/USACO/TextFiles/factory.in";
        Scanner in = new Scanner(new File(inpath));

        int N = in.nextInt();
        list = new Station[N];
        for (int z = 1; z <= N; z++) {
            list[z-1] = new Station(z); //initializes numeric labeling for each station
        }
        for (int z = 0; z < N-1; z++) { //initialize from lists
            int f = in.nextInt()-1, g = in.nextInt()-1;
            list[g].from.add(list[f]); //adds list[f] to the from of list[g]
        }
        in.close();

        //calculate output
        for (Station z: list) {
            HashSet<Station> connected = new HashSet();
            dfs(z,connected);
            if (connected.size() == list.length-1) answer = z.num;
        }

        //write output
        BufferedWriter out = new BufferedWriter(new FileWriter("factory.out"));
        if (debug) System.out.println(answer);
        out.write(answer +"");
        out.close();

    }

    //recursively find all connected stations
    public static void dfs(Station z, HashSet c) {
        for (Station x: z.from) {
            if (c.contains(x)) {
                return;
            }
            else c.add(x);
            dfs(x,c);
        }
    }

}
