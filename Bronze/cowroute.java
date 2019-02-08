import java.io.*;
import java.util.Scanner;
public class cowroute{

    //store Route data
    static class Route {
        int[] cities;
        int numCities;
        int cost;

        public Route(int cost, int numCities) {
            this.numCities = numCities;
            this.cost = cost;
            cities = new int[numCities];
        }

        public int checkRoute(int a, int b) {
            boolean hasA = false;
            boolean hasB = false;
            for (int z = 0; z < numCities; z++) {
                int current = cities[z];
                if (current == a) {
                    hasA = true;
                }
                else if (current == b) {
                    if (hasA) {
                        return this.cost;
                    }
                    hasB = true;
                }

            }
            return -1;
        }//end method

    }


    public static void main(String[] x) throws IOException {
        //initialize file I/O
        File inpath = new File("cowroute.in");
        File outpath = new File("cowroute.out");
        Scanner in = new Scanner(inpath);

        //read data from input & calculate
        int A = in.nextInt();
        int B = in.nextInt();
        int N = in.nextInt();
        int minimum = 1001;
        Route[] routes = new Route[N];

        for (int z1 = 0; z1 < N; z1++) {
            Route a = new Route(in.nextInt(),in.nextInt());
            for (int z2 = 0; z2<a.numCities; z2++) {
                a.cities[z2] = in.nextInt();
            }
            int b = a.checkRoute(A,B);
            if (b < minimum && b >= 0) {
                minimum = b;
            }
        }
        in.close();
        if (minimum == 1001) {
            minimum = -1;
        }
        //write output
        BufferedWriter out = new BufferedWriter(new FileWriter("cowroute.out"));
        System.out.println(minimum);
        out.write(minimum + "");
        out.close();
    }
}


