package dao;

import java.util.List;

import domain.Game;
import domain.Song;

public interface DataAccess {

    public void insertGame(List<Game> gameList);

    public void insertSong(List<Song> songList);

}
