package datos;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Persistencia {
    EntityManager entityManager;
    EntityTransaction transaction;

    public Persistencia(){
        entityManager = PerThreadEntityManagers.getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void persistir(Object unRegistro)
    {
        try {
            transaction.begin();
            entityManager.persist(unRegistro);
            transaction.commit();
        }
        catch(Exception e)
        {
            System.out.println("Error al intentar persistir:\n" + e.getMessage() );
        }
    }
}
