package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;

public class TransactionDao {

    public void persist(Transaction tx) {
        EntityManager em = datasource.MariaDbJpaConnection.getInstance();
        em.getTransaction().begin();
        em.persist(tx);
        em.getTransaction().commit();
    }
}
