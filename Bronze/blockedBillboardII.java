import java.util.Scanner;
import java.io.*;
public class blockedBillboardII {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("billboard.in"));
        int x1 = in.nextInt();
        int y1 = in.nextInt() ;
        int x2 = in.nextInt() ;
        int y2 = in.nextInt();

        int X1 = in.nextInt();
        int Y1 = in.nextInt();
        int X2 = in.nextInt();
        int Y2 = in.nextInt();

        in.close();
//        int fx1, fy1, fx2, fy2;
//
//        if (x1 < X1) fx1 = x1;
//        else fx1 = X1;
//
//        if (x2 < X2) fx2 = x2;
//        else fx2 = X2;
//
//        if (y1 < Y1) fy1 = y1;
//        else fy1 = Y1;
//
//        if (y2 < Y2) fy2 = y2;
//        else fy2 = Y2;

//        int[][] grid = new int[2001][2001];
//
//        for (int z = y1; z < y2; z++) {
//            for(int z1 = x1; z1 < x2; z1++) {
//                grid[z][z1] = 1;
//            }
//        }
//        for (int z = Y1)
//
//        for (int[] y:grid) {
//            for (int x:y) {
//                i
//            }
//        }
        int answer = 0;
        int littleLength = x2-x1;
        int littleWidth = y2-y1;
        int littleArea = (y2-y1) * (x2-x1);

        if (x1 >= X1 && x2 <= X2 && x2 >= X1 && y2 >= Y1 && y1 >= Y1 && y2 <= Y2) { //inside its still 0
            //0
        }
        else if (x1 == X1 && x2 == X2 && y1 == Y1 && y2 == Y2) {
            //0
        }
        else if (x2 < X1 || x1 > X2 || y2 < Y1 || y1 > Y2) {
            answer = littleArea;
        }
        else if (x1 >= X1 && x2 <= X2 && y2 > Y2 && y1 > Y1 && y1 < Y2) {
            answer = Math.abs(y2-Y2)*littleLength;
        }
        else if (x1 >= X1 && x2 <= X2 && y1 < Y1 && y2 < Y2 && y2 > Y1) {
            answer = Math.abs(y1-Y1) * littleLength;
        }

        else if (x1 < X1 && x2 < X2 && x2 > X1 && y1 >= Y1 && y2 <= Y2) {
            answer = littleWidth*Math.abs(x1-X1);
        }

        else if (x1 > X1 && x2 > X2 && x1 < X2 && y1 >= Y1 && y2 <= Y2) {
            answer = littleWidth*Math.abs(x2-X2);
        }
        else if (x1 > X1 && x2 < X2 && y2 >= Y2 && y1 <= Y1) {
            answer = littleArea;
        }
        else if (x1 < X1 && x2 > X2 && y2 >= Y2 && y1 >= Y1) {
            answer = littleArea;
        }

        else {
            answer = littleArea;
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("billboard.out"));
        out.write(answer + "");
        out.close();

    }

}
