package markov;

/* INCOMPLETE */

import java.util.ArrayList;

public class Solution {

	// converts input matrix m to a transition matrix
	public static double[][] transition(int[][] m) {
		
		double[][] t = new double[m.length][m[0].length];
		
		for (int x=0; x<m.length; x++) {
			for (int y=0; y<m[x].length; y++) {
				t[x][y] = m[x][y];
			}
		}
		
		// if terminal state
		for (int i=0; i<m.length; i++) {
			boolean zeros = true;
			int j = 0;
			
			// checking if row contains only zeros
			while (zeros == true && j < m[i].length) {
				if (m[i][j] != 0) {
					zeros = false;
				}
				j++;
			}
			
			if (zeros == true) {
				t[i][i] = 1;
			}
		}
		
		// converting entries to fractions
		for (int k=0; k<t.length; k++) {
			
			double sum = 0;
			
			for (int l=0; l<t[k].length; l++) {
				sum += t[k][l];
			}
			
			for (int l=0; l<t[k].length; l++) {
				t[k][l] = t[k][l] / sum;
			}
			
		}
		
		return t;
	}
	
	// find canonical form
	public static double[][] canonical(double[][] m) {
		
		double[][] c = new double[m.length][m[0].length];
		
		for (int x=0; x<m.length; x++) {
			for (int y=0; y<m[x].length; y++) {
				c[x][y] = m[x][y];
			}
		}
		
		// find terminal states
		ArrayList<Integer> terminalStates = new ArrayList<>();
		
		for (int i=0; i<m.length; i++) {
			boolean zeros = true;
			int j = 0;
			
			// checking if row contains only zeros
			while (zeros == true && j < m[i].length) {
				if (m[i][j] != 0) {
					zeros = false;
				}
				j++;
			}
			
			if (zeros == true) {
				terminalStates.add(i);
			}
		}
		
		
		return null;
	}
	
	// find fundamental
	public static double[][] fundamental(double[][] m) {
		return null;
	}
	
	// swap rows
	public static double[][] swapRows(double[][] input, int row1, int row2) {
		double[][] output = new double[input.length][input[0].length];
		
		for (int i=0; i<input.length; i++) {
			for (int j=0; j<input[i].length; j++) {
				output[i][j] = input[i][j];
			}
		}
		
		output[row1] = input[row2];
		output[row2] = input[row1];
		
		return output;
	}
	
	// swap columns
	public static double[][] swapColumns(double[][] input, int c1, int c2) {
		double[][] output = new double[input.length][input[0].length];
			
		for (int i=0; i<input.length; i++) {
			for (int j=0; j<input[i].length; j++) {
				output[i][j] = input[i][j];
			}
		}
			
		for (int x=0; x<input.length; x++) {
			output[x][c1] = input[x][c2];
			output[x][c2] = input[x][c1];
		}
			
		return output;
	}
	
	public static void printArray(double[][] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		double[][] test = {{0, 1, 0, 0, 0, 1}, {4, 0, 0, 3, 2, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
		//double[][] sol = transition(test);
		
		double[][] swapTest = swapColumns(test, 0, 1);
		printArray(swapTest);
		
	}

}
