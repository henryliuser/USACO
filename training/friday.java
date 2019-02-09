/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: henryli3
LANG: JAVA
PROG: friday 
*/

import java.util.*;
import java.io.*;


public class friday {

	public static String inpath = "friday.in";            // /Users/henry/eclipse-workspace/USACO/src/friday.in
	public static String outpath = "friday.out";          // /Users/henry/eclipse-workspace/USACO/src/friday.out
	
	public static int[] dayCounts = new int[] {31,28,31,30,31,30,31,31,30,31,30,31,29};
	public static int[] totalT = new int[] {0,0,0,0,0,0,0};

	public static int fixDay(int cday) {
		if (cday > 7) {
			int x = fixDay(cday - 7);
			return x;
		}
		return cday;
	}
	
	public static ArrayList<Integer> counter(int N) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (int x: totalT) {
			list1.add(x);
		}
		
		int currentMonth = 1;
		int currentDay = 6;
		int currentDate = 13;
		int currentYear = 1900;
		
		
//		else {
//			list1.set(currentDay-1, list1.get(currentDay-1)+1);
//		}

		
//		int newMonths = newMonths(1,figureOutDays(N))[0];
		int newMonths = N*12;
//		int remainingDays = newMonths(1,N)[1];
		
		
		for (int x = 0; x < newMonths;x++ ) {
			
			double george = currentYear%4;
			double marge = currentYear%100;
		
			
			if (george == 0 && currentMonth == 2) {
				if (marge != 0) {
					currentMonth = 13;
				}
				if (marge == 0 && currentYear%400 == 0 && currentMonth == 2) {
					currentMonth = 13;
				}
			}
			
			if (currentMonth == 14) {
				currentMonth = 3;
			}
			
			list1.set(currentDay-1, list1.get(currentDay-1)+1);
			currentDay += (dayCounts[currentMonth-1] % 7);
			currentDay = fixDay(currentDay);
			currentMonth += 1;
			if (currentMonth == 13) {
				currentMonth = 1;
				currentYear += 1;
			}
		
		}// end for loop
		
		return list1;
		
	}//end counter method
	
	public static int figureOutDays(double years) {
		double tempTear = 1900;
		int yCounter = 0;
		int days = 0;
		int monthI = 0;
		
//		while (true) {
			
			for (int y =0; y< years;y++) {
				double george = tempTear/4;
				double marge = tempTear/100;
				if (marge - Math.floor(marge) == 0 && marge/4 - Math.floor(marge/4) == 0) {
					monthI = 13;
				}
				else if (george - Math.floor(george) == 0 && marge - Math.floor(marge) != 0) {
					monthI = 13;
				}
				
				
				if (monthI == 13) {
					days += 366;
				}
				else {
					days += 365;
				}
				tempTear+=1;
				
					
				
				
			} // end for
		 // end while
			System.out.println(days);
			return days;
	}
	
	
	public static int[] newMonths(int currentMonth, int days) {
		int counter = 0;
		int monthI = 0;
		int totalDays = days;
//		int tempTear = days + 1900;
//		int yCounter = 0;
//		
		
		
		
		while (true) {
			
//			for (int y =0; y<= tempTear;y++) {
//				double george = tempTear/4;
//				double marge = tempTear/100;
//				if (george - Math.floor(george) == 0) {
//					monthI = 13;
//				}
//				if (marge - Math.floor(marge) == 0 && marge/4 - Math.floor(marge/4) == 0) {
//					monthI = 13;
//				}
//				if (currentMonth == 14) {
//					monthI = 3;
//				}
//				
//			}
			
			if (totalDays < dayCounts[monthI]) {
				if (totalDays >= 13) {
					counter++;
				}
				break;
			}
			totalDays -= dayCounts[monthI];
			counter += 1;
			if (monthI == 11) {
				monthI = 1;
			}
			else if (monthI == 12) {
				monthI = 3;
			}
			else {
				monthI += 1;
			}
		
		}//end while loop
		int[] stuff = new int[] {counter,totalDays};
		return (stuff);
	}//end method
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(inpath));
		int n = Integer.parseInt(f.readLine());
		ArrayList<String> stuff = new ArrayList<String>();
		f.close();
		for (int x: counter(n)) {
			stuff.add(Integer.toString(x));
		}
		PrintWriter o = new PrintWriter(new BufferedWriter(new FileWriter(outpath)));
		System.out.println(stuff.get(5)+" "+stuff.get(6)+" "+stuff.get(0)+" "+stuff.get(1)+" "+stuff.get(2)+" "+stuff.get(3)+" "+stuff.get(4)+" ");
		
		o.write(stuff.get(5)+" "+stuff.get(6)+" "+stuff.get(0)+" "+stuff.get(1)+" "+stuff.get(2)+" "+stuff.get(3)+" "+stuff.get(4) + "\n");
		o.close();

	}// end main

}//end class
