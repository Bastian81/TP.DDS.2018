package general;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();



        transaction.begin();
        Categoria unaCategoria = new Categoria("R1",0,150, (float)18.76, (float)0.664);
        entityManager.persist(unaCategoria);
        transaction.commit();


    }
}
