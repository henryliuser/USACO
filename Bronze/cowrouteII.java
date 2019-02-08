import java.io.*;
import java.util.*;

public class cowrouteII { //absMin is never changed

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
        BufferedWriter out;

        //read data from input & calculate
        int A = in.nextInt();
        int B = in.nextInt();
        int N = in.nextInt();
        int absMin = 1001;
        //List to store the cheapest price of connections from A to B
        HashMap<Integer,Integer> connectionsA = new HashMap<>();
        HashMap<Integer,Integer> connectionsB = new HashMap<>();
        int bothMin = 1001;

        for (int z1 = 0; z1 < N; z1++) {
            HashMap<Integer,Integer> revert = (HashMap)connectionsB.clone();
            boolean reachedA = false;
            boolean reachedB = false;
            Route a = new Route(in.nextInt(),in.nextInt());  //Store current route
            for (int z2 = 0; z2<a.numCities; z2++) { //Read each city in
                int curr = in.nextInt();
                a.cities[z2] = curr;               //Append current city to route list
                if (curr == A) reachedA = true;     //set markers when encountered
                if (curr == B) reachedB = true;

                if (reachedA && !reachedB) {  //if it's after A and before B
                    if (!connectionsA.containsKey(curr)) { //if it hasnt reached
                        connectionsA.put(curr,a.cost);
                    }
                    else {
                        if (connectionsA.get(curr) > a.cost) {
                            connectionsA.put(curr,a.cost);
                        }
                    }
                }
                else if (!reachedB) {          //hasnt reached either
                    if (connectionsB.containsKey(curr)) {  //then update hashmap
                        if (connectionsB.get(curr) > a.cost) {
                            connectionsB.put(curr,a.cost);
                        }
                    }
                    else {connectionsB.put(curr,a.cost);}

                }

            if (reachedA && reachedB) {
                if (a.cost < bothMin) {
                    bothMin = a.cost;
                }
            }
            if (!reachedB) connectionsB = revert;
            }// end data for
        }// end route for
        in.close();

        //calculate routes
        Iterator loopA = connectionsA.entrySet().iterator();


        while (loopA.hasNext()) {
            Map.Entry pairA = (Map.Entry)loopA.next();
            if (connectionsB.containsKey(pairA.getKey())) {
                int c = (int)pairA.getValue() + connectionsB.get(pairA.getKey());
                if (c < absMin) {
                    absMin = c;
                }
            }
        }
        absMin = Math.max(absMin,bothMin);

        //write output
        out = new BufferedWriter(new FileWriter(outpath));
        System.out.println(absMin);
        out.write(absMin + "");
        out.close();
    }
}


