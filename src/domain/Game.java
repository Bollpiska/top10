package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
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

    public Game() {

    }

}
