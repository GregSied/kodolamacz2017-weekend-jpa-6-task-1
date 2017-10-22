package test;

import javax.persistence.EntityManager;

public class ShopDao {
  private final EntityManager entityManager;

  public ShopDao(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public void insert(Shop shop) {
    entityManager.getTransaction().begin();
    entityManager.persist(shop);
    entityManager.getTransaction().commit();
  }
}
