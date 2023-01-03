package salute;

public class Solution {
	public static int solution(String s) {
		
		int totalSalutes = 0;
		int right = s.indexOf('>');
		
		while (right > -1) {
			
			int left = s.indexOf('<', right+1);
			
			while (left > -1) {
				
				totalSalutes++;
				left = s.indexOf('<', left+1);
				
			}
			right = s.indexOf('>', right+1);
			
		}
		
		totalSalutes = totalSalutes * 2;
		
		return totalSalutes;
	}
	
	public static void main(String[] args) {
		System.out.println(Solution.solution(">--<"));
	}
}
