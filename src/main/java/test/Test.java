package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static java.lang.Math.random;

public class Test {
  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("Hello Shutdown!");
      entityManager.close();
      entityManagerFactory.close();
    }));

    while (true) {
      entityManager.getTransaction().begin();
      Shop notebook = new Shop("name" + random(), "address" + random());
      entityManager.persist(notebook);
      entityManager.getTransaction().commit();
    }
  }
}
