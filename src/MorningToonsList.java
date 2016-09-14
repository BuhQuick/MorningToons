import java.util.Scanner;

/**
 * Basic program to help roommates and I pick Sunday morning cartoons.
 * ToonPicker picks x shows based on user input using read-in csv file
 * @author Nicholas Buquicchio
 *
 */
public class MorningToonsList {

	public static void main(String[] args) {
		// Usually each block == 1 hour
		System.out.print("How many cartoon blocks do we want? ");
		Scanner sc = new Scanner(System.in);
		int blocks = sc.nextInt();
		sc.close();
		String[] shows = new ToonPicker(args[0]).getShows(blocks);
		
		System.out.println("Today's regularly scheduled programming: ");
		for (int n = 0; n < shows.length; n += 1) {
			System.out.println((n + 1) + ": " + shows[n]);
		}
	}

}
