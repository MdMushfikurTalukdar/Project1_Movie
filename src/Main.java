import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieApp movieApp = new MovieApp();

        // Sample movies
        movieApp.addMovie(new Movie("The Shawshank Redemption", List.of("Tim Robbins", "Morgan Freeman"), "Drama", "1994", 25000000));
        movieApp.addMovie(new Movie("The Godfather", List.of("Marlon Brando", "Al Pacino"), "Crime", "1972", 6000000));
        movieApp.addMovie(new Movie("The Dark Knight", List.of("Christian Bale", "Heath Ledger"), "Action", "2008", 185000000));

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
                System.out.println("");
                System.out.println("1. Add to Favorites");
                System.out.println("2. Remove from Favorites");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choiceNew = scanner.nextInt();
                scanner.nextLine();
                if(choiceNew==1){
                    System.out.print("Enter User email : ");
                    String userName = scanner.nextLine();
                    User user = new user(userName);
                    movieApp.addFavorite(userName,query);
                }
                else if (choiceNew==2) {

                }
                else if (choiceNew==0) {
                    System.out.println("Thank you for using Movie App. Goodbye!");
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
            else if (choice==3){
                // Add to favorites
                System.out.print("Enter ");
                movieApp.addFavorite(,);
            }
            else if (choice==4){
                // Remove from favorites
            }
            else if (choice==5){
                // View favorites
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