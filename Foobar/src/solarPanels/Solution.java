package solarPanels;

import java.util.ArrayList;

public class Solution {
	public static int[] solution(int area) {
		
		if (area < 1 || area > 1000000) {
			System.out.println("Area must be within range 1 to 1000000 inclusive.");
			return null;
		}
		
		ArrayList<Integer> squaresArrayList = new ArrayList<>();
		
		while (area > 0) {
			int sqrRoot = (int)Math.floor(Math.sqrt(area));
			
			int sqr = sqrRoot * sqrRoot;
			squaresArrayList.add(sqr);
			
			area = area - sqr;
		}
		
		int[] squares = new int[squaresArrayList.size()];
		
		for (int i=0; i<squares.length; i++) {
			squares[i] = squaresArrayList.get(i);
		}
		
		return squares;
		
	}
	
	public static void main(String[] args) {
		Solution.solution(0);
		
		int[] panels = Solution.solution(102);
		
		for (int p : panels) {
			System.out.println(p);
		}
	}
}
