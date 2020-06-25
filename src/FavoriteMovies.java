import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class FavoriteMovies {
    public static void main(String[] args) {
        ArrayList<String> favoriteMovies = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean firstOne = true;
        boolean askAgain = true;
        do {
            if (!firstOne)   System.out.println("Enter your next favorite movie or (\"q\" or \"Q\" to stop)");
            else {
                System.out.println("Enter your favorite movie");
                firstOne = false;
            }
            String inputString = scanner.next();
            String copyOfInputString = new String(inputString);

            if (inputString.length() == 1)
                askAgain = !(copyOfInputString.toLowerCase().charAt(0) == 'q');
            if (askAgain) favoriteMovies.add(inputString);

        } while(askAgain);

        // Print the list of movies before exiting the program.
        System.out.println("Favorite movies in the order they were inserted: ");
        printAllFavMovies(favoriteMovies, false);
        System.out.println();

        //  Print out the list of movies sorted in alphabetical order.
        System.out.println("Favorite movies sorted in alphabetical order: ");
        Collections.sort(favoriteMovies);
        printAllFavMovies(favoriteMovies, true);
        System.out.println("");

        /* Suggest a movie to the user to watch by randomly selecting a movie
           from the list of movies entered. */
        Random random = new Random();
        int randomIndex = random.nextInt(favoriteMovies.size());

        System.out.printf("You should definitely watch \"%s\" once again!\n" ,
                favoriteMovies.get(randomIndex));

    }

    public static void printAllFavMovies(ArrayList<String> favoriteMovies, boolean isDashed) {
        for (int movieIdx = 0; movieIdx < favoriteMovies.size(); movieIdx++) {

            if (isDashed) {
                System.out.println("\t- " +favoriteMovies.get(movieIdx));
            } else {
                System.out.println("\t" + (movieIdx + 1) + ". " + favoriteMovies.get(movieIdx));
            }
        }
    }
}


