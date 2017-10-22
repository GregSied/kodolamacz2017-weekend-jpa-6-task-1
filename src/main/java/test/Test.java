package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
  public static void main(String[] args) throws InterruptedException {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      System.out.println("Hello Shutdown!");
      entityManager.close();
      entityManagerFactory.close();
    }));

    Stepper stepper = new Stepper();
    ShopDao shopDao = new ShopDao(entityManager);
    Inserter inserter = new Inserter(stepper, shopDao);

    while (true) {
      inserter.insert();
    }
  }
}
