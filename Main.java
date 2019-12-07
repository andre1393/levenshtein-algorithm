public class Main {

	public static void main(String[] args) {
		final int n = 4;

		String[] tokens1 = new String[]{"Haus", "Haus", "Haus", "Kartoffelsalat"};
		String[] tokens2 = new String[]{"Maus", "Mausi", "Häuser", "Runkelrüben"};
		int[] distances = new int[]{1, 2, 3, 12};

		Solution solution = new Solution();
		for(int i=0; i<n; i++) {
			System.out.printf("lev(%s, %s) = %d (expected = %d)\n", tokens1[i], tokens2[i], solution.levenshtein(tokens1[i], tokens2[i]), distances[i]);
		}
	}
}