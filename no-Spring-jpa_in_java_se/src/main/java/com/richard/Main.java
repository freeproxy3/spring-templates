package com.richard;

import javax.persistence.EntityManager;

public class Main {
  public static void main(String[] args) {
    Address address = new Address();
    address.setStreet("Poribagh");
    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
    em.getTransaction()
        .begin();
    em.persist(address);
    em.getTransaction()
        .commit();
    em.close();
    PersistenceManager.INSTANCE.close();
  }
}