import java.time.Duration;
import java.time.Instant;

public class Main {

	public static void main(String[] args) {
		final int maxDistance = 2;

		System.out.println("Exercises 1/2: \n");
		runLevenshteinTests();
		System.out.println("-----------------------------------------");
		System.out.println("Exercises 3/4: \n");
		runLevenshteinWithEarlyTests(maxDistance);
		System.out.println("-----------------------------------------");
		System.out.println("Exercise 5: \n");
		long test1 = runLevenshteinPerformanceTests(10000);
		System.out.println("\n");
		long test2 = runLevenshteinWithEarlyExitPerformanceTests(10000, maxDistance);
		System.out.printf("\nLeveshtein with early exit was %d nano seconds faster than the regular one.\n", test1-test2);
	}

	// exercise 2
	public static void runLevenshteinTests() {
		final int n = 4;

		String[] tokens1 = new String[]{"Haus", "Haus", "Haus", "Kartoffelsalat"};
		String[] tokens2 = new String[]{"Maus", "Mausi", "Häuser", "Runkelrüben"};
		int[] distances = new int[]{1, 2, 3, 12};

		Solution solution = new Solution();

		for(int i=0; i<n; i++) {
			System.out.printf("lev(%s, %s) = %d (expected = %d)\n", tokens1[i], tokens2[i], solution.levenshtein(tokens1[i], tokens2[i]), distances[i]);
		}
	}

	// exercise 4
	public static void runLevenshteinWithEarlyTests(int maxDistance) {
	    final int n = 4;

		String[] tokens1 = new String[]{"Haus", "Haus", "Haus", "Kartoffelsalat"};
		String[] tokens2 = new String[]{"Maus", "Mausi", "Häuser", "Runkelrüben"};
		int[] distances = new int[]{1, 2, 3, 3};

		Solution solution = new Solution();
		for(int i=0; i<n; i++) {
			System.out.printf("lev(%s, %s) = %d (expected = %d)\n", tokens1[i], tokens2[i], solution.levenshtein(tokens1[i], tokens2[i], maxDistance), distances[i]);
		}
	}

	public static long runLevenshteinPerformanceTests(int nTests) {
		final int n = 4;

		String[] tokens1 = new String[]{"Haus", "Haus", "Haus", "Kartoffelsalat"};
		String[] tokens2 = new String[]{"Maus", "Mausi", "Häuser", "Runkelrüben"};

		Solution solution = new Solution();

		System.out.println("performance test of levenshtein:");
		
		long startTest = System.nanoTime();

		for(int t=0; t<nTests; t++){
			for(int i=0; i<n; i++) {
				solution.levenshtein(tokens1[i], tokens2[i]);
			}
		}

		long elapsedTime = System.nanoTime()-startTest;
		System.out.printf("time elapsed to process all words pairs: %d nano seconds\n", elapsedTime);

		return elapsedTime;
	}

	public static long runLevenshteinWithEarlyExitPerformanceTests(int nTests, int maxDistance) {
		final int n = 4;

		String[] tokens1 = new String[]{"Haus", "Haus", "Haus", "Kartoffelsalat"};
		String[] tokens2 = new String[]{"Maus", "Mausi", "Häuser", "Runkelrüben"};

		Solution solution = new Solution();

		System.out.println("performance test of levenshtein with early exit:");
		
		long startTest = System.nanoTime();
		
		for(int t=0; t<nTests; t++) {
			for(int i=0; i<n; i++) {
				solution.levenshtein(tokens1[i], tokens2[i], maxDistance);
			}
		}

		long elapsedTime = System.nanoTime()-startTest;
		System.out.printf("time elapsed to process all words pairs: %d nano seconds\n", elapsedTime);
		
		return elapsedTime;
	}
}