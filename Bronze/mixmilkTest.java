import java.util.Scanner;
import java.io.*;
public class mixmilkTest {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("mixmilk.in"));
        int[] maxCapacity = new int[3];
        int[] currentMilk = new int[3];

        for (int z = 0; z < 3; z++) {
            maxCapacity[z] = in.nextInt();
            currentMilk[z] = in.nextInt();
        }
        in.close();

        for (int z = 0; z < 33; z++) {
            int available = maxCapacity[1] - currentMilk[1];
            if (currentMilk[0] <= available) {
                currentMilk[1] += currentMilk[0];
                currentMilk[0] = 0;
            }
            else {
                currentMilk[0] -= available;
                currentMilk[1] = maxCapacity[1];
            }

            available = maxCapacity[2] - currentMilk[2];
            if (currentMilk[1] <= available) {
                currentMilk[2] += currentMilk[1];
                currentMilk[1] = 0;
            }
            else {
                currentMilk[1] -= available;
                currentMilk[2] = maxCapacity[2];
            }

            available = maxCapacity[0] - currentMilk[0];
            if (currentMilk[2] <= available) {
                currentMilk[0] += currentMilk[2];
                currentMilk[2] = 0;
            }
            else {
                currentMilk[2] -= available;
                currentMilk[0] = maxCapacity[0];
            }

        }

        int available = maxCapacity[1] - currentMilk[1];
        if (currentMilk[0] <= available) {
            currentMilk[1] += currentMilk[0];
            currentMilk[0] = 0;
        }
        else {
            currentMilk[0] -= available;
            currentMilk[1] = maxCapacity[1];
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("mixmilk.out"));
        for (int z = 0; z < 3; z++) {
            out.write(currentMilk[z] + "\n");
        }
        out.close();



    }
}
