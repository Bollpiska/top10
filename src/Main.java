import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Game;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("toptiodataDB");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Game game1 = new Game("Fia med Knuff", 10.0, "Jävligt nice spel", "1897", 4);

        em.persist(game1);

        tx.commit();
        em.close();

    }

}
