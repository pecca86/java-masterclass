package polymorphism;

public class Comedy implements Movie {
    private String title;
    private int releaseYear;
    private String plot;

    public Comedy(String title, int releaseYear, String plot) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.plot = plot;

    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int releaseYear() {
        return this.releaseYear;
    }

    @Override
    public String plot() {
        return this.plot;
    }
}
