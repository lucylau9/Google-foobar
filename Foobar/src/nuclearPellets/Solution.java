package nuclearPellets;

import java.math.BigInteger;

public class Solution {
	public static int solution(String x) {
		
		int count = 0;
		
		// convert x to integer called n
		BigInteger n = new BigInteger(x);
		
		// keep performing operations until n == 1
		while (!n.equals(BigInteger.ONE)) {
			
			if (n.remainder(new BigInteger("2")).equals(BigInteger.ZERO)) {
				n = n.divide(new BigInteger("2"));
			}
			else if (n.equals(new BigInteger("3")) || n.remainder(new BigInteger("4")).equals(BigInteger.ONE)) {
				n = n.subtract(BigInteger.ONE);
			}
			else {
				n = n.add(BigInteger.ONE);
			}
			count++;
			
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("99999999999999999999999999999999999999999999999999999999999999999"));
	}

}
