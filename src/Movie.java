import java.util.List;

class Movie {
    private String title,category,releaseDate;
    private double budget;
    private List<String> cast;

    public Movie(String title, List<String> cast, String category, String releaseDate, double budget) {
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCast() {
        return cast;
    }

    public String getCategory() {
        return category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "\bTitle: " + title + "\n" +
        "Cast: " + cast + "\n" +
        "Category: " + category + "\n" +
        "Release Date: " + releaseDate + "\n" +
        "Budget: " + budget + "\n";
    }
}
