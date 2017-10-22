package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static java.lang.Math.random;

public class Test {
  public static void main(String[] args) throws InterruptedException {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("Hello Shutdown!");
      entityManager.close();
      entityManagerFactory.close();
    }));

    while (true) {
      Thread.sleep(1000);
      entityManager.getTransaction().begin();
      Shop shop = new Shop("name" + random(), "address" + random());
      System.out.println("Persisting:");
      System.out.println(shop);
      entityManager.persist(shop);
      entityManager.getTransaction().commit();
    }
  }
}
