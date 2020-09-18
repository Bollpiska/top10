package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Game;
import domain.Song;

public class DataAccessImpl implements DataAccess {

    @Override
    public void insertGame(List<Game> gameList) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("toptiodataDB");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        for (Game game : gameList) {

            em.persist(game);
        }

        tx.commit();
        em.close();

    }

    @Override
    public void insertSong(List<Song> songList) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("toptiodataDB");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        for (Song song : songList) {

            em.persist(song);
        }

        tx.commit();
        em.close();

    }

}
