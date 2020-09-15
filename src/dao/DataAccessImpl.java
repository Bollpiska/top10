package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Game;

public class DataAccessImpl implements DataAccess {

    @Override
    public void insert() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("toptiodataDB");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Game game1 = new Game("Nomolop", 10.0, "Nice spel", "1897", 4);

        em.persist(game1);

        tx.commit();
        em.close();

    }

}
