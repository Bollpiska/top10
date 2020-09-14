package domain;

public class Game {

    private String name;
    private double rating;
    private String description;
    private String releaseDate;
    private int maxNumPlayers;

    public Game(String name, double rating, String description, String releaseDate, int maxNumPlayers) {
        this.name = name;
        this.rating = rating;
        this.description = description;
        this.releaseDate = releaseDate;
        this.maxNumPlayers = maxNumPlayers;
    }

}
