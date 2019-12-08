import java.lang.Math;

public class Solution {

	// exercise 1
	public int levenshtein(String token1, String token2) {
		final int lenToken1 = token1.length();
		final int lenToken2 = token2.length();
       
		int cost;

		// allocate first column
		int[] column = new int[lenToken1+1];

		// initialize fill first column
		for(int i=0; i<=lenToken1; i++) {
			column[i] = i;
		}

		// iterate over columns
        for(int j=1; j<=lenToken2; j++) {
        	int oldValue = j-1; // value to replaced
        	int newValue = j; // value replaced

        	// iterate over rows
			for(int i=1; i<=lenToken1; i++) {
			column[i-1] = newValue;

				if(token1.charAt(i-1) == token2.charAt(j-1)) cost = 0;
				else cost = 1;

				newValue = this.min(column[i] + 1, column[i-1] + 1, oldValue + cost);
				
				// before replacing new value, save the old one
				oldValue = column[i];

				column[i] = newValue;
			}
        }

		return column[lenToken1];
	}

	// exercise 3
	public int levenshtein(String token1, String token2, int maxDist) {
		final int lenToken1 = token1.length();
		final int lenToken2 = token2.length();
       
		int cost;

		// allocate first column
		int[] column = new int[lenToken1+1];

		// initialize fill first column
		for(int i=0; i<=lenToken1; i++) {
			column[i] = i;
		}

		// iterate over columns
        for(int j=1; j<=lenToken2; j++) {
        	int oldValue = j-1; // value to replaced
        	int newValue = j; // value replaced

        	// iterate over rows
			for(int i=1; i<=lenToken1; i++) {
			column[i-1] = newValue;

				if(token1.charAt(i-1) == token2.charAt(j-1)) cost = 0;
				else cost = 1;

				newValue = this.min(column[i] + 1, column[i-1] + 1, oldValue + cost);
				
				// before replacing new value, save the old one
				oldValue = column[i];

				column[i] = newValue;
			}

			if(column[Math.min(lenToken1, j)] > maxDist)
				return maxDist + 1;
        }

		return column[lenToken1];
	}

	private int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}
}