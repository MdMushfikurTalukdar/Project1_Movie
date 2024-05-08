import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp();

        // Sample movies
        movieApp.addMovie(new Movie("The Shawshank Redemption", List.of("Tim Robbins", "Morgan Freeman"), "Drama", "1994", 25000000));
        movieApp.addMovie(new Movie("The Godfather", List.of("Marlon Brando", "Al Pacino"), "Crime", "1972", 6000000));
        movieApp.addMovie(new Movie("The Dark Knight", List.of("Christian Bale", "Heath Ledger"), "Action", "2008", 185000000));
        movieApp.addMovie(new Movie("The Matrix", List.of("Keanu Reeves", "Carrie-Anne Moss"), "Sci-Fi", "1999", 63000000));
        movieApp.addMovie(new Movie("Inception", List.of("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "Sci-Fi", "2010", 160000000));
        movieApp.addMovie(new Movie("The Lord of the Rings: The Fellowship of the Ring", List.of("Elijah Wood", "Ian McKellen"), "Fantasy", "2001", 93000000));
        movieApp.addMovie(new Movie("The Avengers", List.of("Robert Downey Jr.", "Chris Evans"), "Action", "2012", 220000000));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to Movie App");
            System.out.println("1. Register");
            System.out.println("2. Search Movies");
            System.out.println("3. Add to Favorites");
            System.out.println("4. Remove from Favorites");
            System.out.println("5. View Favorites");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice==1){
                movieApp.registerUser();
            }
            else if (choice==2){
                System.out.print("Enter search query: ");
                String query = scanner.nextLine();
                movieApp.searchMovies(query);
            }
            else if (choice==3){
                System.out.print("Enter your email address: ");
                String email = scanner.nextLine();
                System.out.print("Enter the title of the movie you want to add to favorites: ");
                String movieTitle = scanner.nextLine();
                User userToAddFavorite = movieApp.findUserByEmail(email);
                if (userToAddFavorite != null) {
                    Movie movieToAddFavorite = movieApp.findMovieByTitle(movieTitle);
                    if (movieToAddFavorite != null) {
                        movieApp.addFavorite(userToAddFavorite, movieToAddFavorite);
                    } else {
                        System.out.println("Movie not found.");
                    }
                } else {
                    System.out.println("User not found.");
                }
            }
            else if (choice==4){
                System.out.print("Enter your email address: ");
                String email = scanner.nextLine();
                System.out.print("Enter the title of the movie you want to remove from favorites: ");
                String movieTitle = scanner.nextLine();
                User userToRemoveFavorite = movieApp.findUserByEmail(email);
                if (userToRemoveFavorite != null) {
                    Movie movieToRemoveFavorite = movieApp.findMovieByTitle(movieTitle);
                    if (movieToRemoveFavorite != null) {
                        movieApp.removeFavorite(userToRemoveFavorite, movieToRemoveFavorite);
                    } else {
                        System.out.println("Movie not found.");
                    }
                } else {
                    System.out.println("User not found.");
                }
            }
            else if (choice==5){
                System.out.print("Enter your email address: ");
                String email = scanner.nextLine();
                User userToViewFavorites = movieApp.findUserByEmail(email);
                if (userToViewFavorites != null) {
                    movieApp.displayUserFavorites(userToViewFavorites);
                } else {
                    System.out.println("User not found.");
                }
            }
            else if (choice==6){
                System.out.println("Thank you for using Movie App. Goodbye!");
                System.exit(0);
                break;
            }
            else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}