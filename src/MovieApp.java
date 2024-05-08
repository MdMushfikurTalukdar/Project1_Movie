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

    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;  // User not found
    }

    public Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;  // Movie not found
    }


    public void searchMovies(String query) {
        System.out.println("Search results:");
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase())) {
                System.out.println(movie);
            } else {
                boolean foundInCast = false;
                for (String actor : movie.getCast()) {
                    if (actor.toLowerCase().contains(query.toLowerCase())) {
                        foundInCast = true;
                        break;
                    }
                }
                if (foundInCast) {
                    System.out.println(movie);
                }
            }
        }
    }


    public void displayMovieDetails(Movie movie) {
        System.out.println(movie);
    }

    public void addFavorite(User user, Movie movie) {
//        for (User user : user) {
//            if (users.getEmail().toLowerCase().contains(user.toLowerCase())) {
//                users.addFavorite(movie);
//            }
//        }
        user.addFavorite(movie);
        System.out.println("Movie added to favorites.");
    }

    public void removeFavorite(User user, Movie movie) {
        user.removeFavorite(movie);
        System.out.println("Movie removed from favorites.");
    }

    public void displayUserFavorites(User user) {
        List<Movie> favorites = user.getFavorites();
        if (favorites.isEmpty()) {
            System.out.println("You have no favorite movies.");
        } else {
            System.out.println("Your favorite movies:");
            for (Movie movie : favorites) {
                System.out.println(movie.getTitle());
            }
        }
    }

}