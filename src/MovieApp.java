import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MovieApp {
    private List<Movie> movies;
    private List<User> users;
    private Scanner scanner;

    public MovieApp() {
        this.movies = new ArrayList<>();
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void registerUser() {
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        User user = new User(email);
        users.add(user);
        System.out.println("Registration successful!");
    }

    public void exixtingUser(){
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        for (User user : users) {
            if (user.getEmail().toLowerCase().contains(email.toLowerCase())) {

            }
        }

    }

    public void searchMovies(String query) {
        System.out.println("Search results:");
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getCast().contains(query.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(movie);
            }
        }
    }

    public void displayMovieDetails(Movie movie) {
        System.out.println(movie);
    }

    public void addFavorite(User user, String query) {
//        for (User user : user) {
//            if (users.getEmail().toLowerCase().contains(user.toLowerCase())) {
//                users.addFavorite(movie);
//            }
//        }
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    movie.getCast().contains(query.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(query.toLowerCase())) {
                user.addFavorite(movie);
            }
        }

        System.out.println("Movie added to favorites.");
    }

    public void removeFavorite(User user, Movie movie) {
        user.removeFavorite(movie);
        System.out.println("Movie removed from favorites.");
    }

    public void displayUserFavorites(User user) {
        System.out.println("Your favorite movies:");
        for (Movie movie : user.getFavorites()) {
            System.out.println(movie);
        }
    }

}