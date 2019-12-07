import java.lang.Math;

public class Solution {

	public int levenshtein(String token1, String token2) {
		final int lenToken1 = token1.length();
		final int lenToken2 = token2.length();

		int[][] m = new int[lenToken1+1][lenToken2+1];
		int cost;

		for(int i=0; i<=lenToken1; i++) {
			m[i][0] = i;
		}

		for(int j=0; j<=lenToken2; j++) {
			m[0][j] = j;
		}

		for(int j=1; j<=lenToken2; j++) {
			for(int i=1; i<=lenToken1; i++) {
				if(token1.charAt(i-1) == token2.charAt(j-1)) cost = 0;
				else cost = 1;
				
				m[i][j] = this.min(m[i-1][j] + 1, m[i][j-1] + 1, m[i-1][j-1] + cost);
			}
		}

		return m[lenToken1][lenToken2];
	}

	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	private void printMatrix(int[][] m, String token1, String token2) {
		int lenToken1 = token1.length();
		int lenToken2 = token2.length();

        System.out.print("\t");
		for(int j=0; j < lenToken2; j++) {
			System.out.print("\t" + token2.charAt(j));
		}
		System.out.println("\n");
		for(int i = 0; i <= lenToken1; i++) {
			if(i > 0) System.out.print(token1.charAt(i-1) + " |");
			for(int j = 0; j <= lenToken2; j++) {
				System.out.print("\t" + m[i][j]);
				if(i == j) System.out.print("*");
			}
			System.out.println("");
		}
	}
}