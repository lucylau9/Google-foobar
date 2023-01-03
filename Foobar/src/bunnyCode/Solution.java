package bunnyCode;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public static int solution(int[] l) {
		
		//reverse sorting l
		ArrayList<Integer> digits = new ArrayList<>();
		for (int i : l) {
			digits.add(i);
		}
		Collections.sort(digits, Collections.reverseOrder());
		for (int i=0; i<digits.size(); i++) {
			l[i] = digits.get(i);
		}
		
		// if empty array
		if (l.length == 0)
			return 0;
		
		// if whole array is the solution
		else if (sumArray(l) % 3 == 0) {
			String s = "";
			for (int d : l) {
				s += d;
			}
			
			return Integer.valueOf(s);
			
		}
		
		// else start checking combinations
		else {
			boolean found = false;
			int i = l.length - 1;
			int solution = 0;
			
			while (found == false && i > 0) {
				ArrayList<int[]> combinations = getCombinations(l, l.length, i);
				
				for (int[] j : combinations) {
					if (sumArray(j) % 3 == 0) {
						String s = "";
						for (int k : j) {
							s += k;
						}
						solution = Integer.valueOf(s);
						found = true;
						break;
					}
				}
				i--;
			}
			
			return solution;
		}
	}
	
	// returns sum of all integers in an array
	private static int sumArray(int[] array) {
		int result = 0;
		for (int i : array) {
			result = result + i;
		}
		return result;
	}

	/* generates all combinations size k from an array.
	 * code taken from https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
	 */
	private static void combinationUtil(int[] array, int data[], int start, 
										int end, int index, int k, ArrayList<int[]> combos) {
		
		if (index == k) {
			int[] copy = data.clone();
			combos.add(copy);
			return; 
		}
		
		else {
			for (int i=start; i<=end && end-i+1 >= k-index; i++) {
				data[index] = array[i];
				combinationUtil(array, data, i+1, end, index+1, k, combos);
			}
		}
		
	}
	
	// returns the combinations
	private static ArrayList<int[]> getCombinations(int[] array, int n, int k) {

		ArrayList<int[]> combos = new ArrayList<>();
		int[] data = new int[k];
		combinationUtil(array, data, 0, n-1, 0, k, combos);
		
		return combos;
		
	}

	
	public static void main(String[] args) {
		
		int[] test = {3, 1, 4, 9};
		
		System.out.println(Solution.solution(test));
	}

}
