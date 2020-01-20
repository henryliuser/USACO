import java.util.*;
import java.io.*;

public class cowjump {

    public static class Line implements Comparable<Line> {
        int orderNumber;
        long x1, x2;
        long y1, y2;
        int intersections = 0;

        public Line(long a, long b, long c, long d, int z) {
            orderNumber = z;
            x1 = a;
            y1 = b;
            x2 = c;
            y2 = d;
        }

        public boolean intersects(Line a) {
            double m1 = (y2-y1+0.0)/(x2-x1);
            double m2 = (a.y2-a.y1+0.0)/(a.x2-a.x1);
            double x_int = (a.y1 + m1*x1 - m2*a.x1 - y1)/(m1-m2);
            if(x1 <= x_int && x_int <= x2 && a.x1 < x_int && x_int <= a.x2) {
                return true;
            }
            return false;
        }

        public int compareTo(Line a) {
            return (int)(x1 - a.x1);
        }

    }


    //global variables
    static ArrayList<Line> lines = new ArrayList();


//    //method to check if two lines intersect
//    static boolean intersect(Line a1, Line a2) {
//        double a = (double)(a1.y2-a1.y1)/(a1.x2-a1.x1);
//        double b = (double)(a2.y2-a2.y1)/(a2.x2-a2.x1);
//
//        double x_int = (a2.y1 + a*a1.x1 - b*a2.x1-a1.y1)/(a - b );
//        if (a1.x1 <= x_int && x_int <= a1.x2 && a2.x1 < x_int && x_int <= a2.x2) return true;
//        return false;
//    }

    static boolean debug = false;
    public static void main(String[] args) throws IOException {

        //take input initialize data
        String inpath = "cowjump.in";
        if (debug) inpath = "/Users/henryliu/IdeaProjects/USACO/TextFiles/cowjump.in";
        Scanner in = new Scanner(new File(inpath));
        int N = in.nextInt();
        for (int z = 0; z < N; z++) {

            long a = in.nextLong(), b = in.nextLong(), c = in.nextLong(), d = in.nextLong();
            if (a > c) {    //SWITCHES VARIABLES SUCH THAT POINT WITH LOWER X1 GOES FIRST
                long temp = a;
                a = c;
                c = temp;

                temp = b;
                b = d;
                d = temp;
            }

            lines.add(new Line(a,b,c,d,z+1));
        }
        in.close();
        Collections.sort(lines);

        ArrayList<Integer> log = new ArrayList();

        BufferedWriter out = new BufferedWriter(new FileWriter("cowjump.out"));

        boolean found = false;

        for (int z = 0; z < N; z++) {
            Line temp1 = lines.get(z);
            for(int a = z + 1; a < N; a++) {
                Line temp2 = lines.get(a);

                if(temp2.x1 > temp1.x2) {
                    break;
                }

                if(temp1.intersects(temp2)) {
                    temp1.intersections++;
                    temp2.intersections++;
                }
                if(temp1.intersections == 1) {
                    log.add(temp1.orderNumber);
                }
                if(temp2.intersections == 1) {
                    log.add(temp2.orderNumber);
                }
                if(temp1.intersections > 1) {
                    found = true;
                    out.write(temp1.orderNumber + "");
                    out.close();
                    break;
                }
                if(temp2.intersections > 1) {
                    found = true;
                    out.write(temp2.orderNumber + "");
                    out.close();
                    break;
                }
            }

            if(found) {
                break;
            }
        }

        if(!found) {
            Collections.sort(log);
            out.write(log.get(0) + 1 + "");
            out.close();
        }

    }//end main
}
