package test;

import static java.lang.Math.random;

public class Inserter {

  private final Stepper stepper;
  private final ShopDao shopDao;

  public Inserter(Stepper stepper,
                  ShopDao shopDao
  ) {
    this.stepper = stepper;
    this.shopDao = shopDao;
  }

  public void insert() throws InterruptedException {
    stepper.step();
    Shop shop = new Shop("name" + random(), "address" + random());
    System.out.println("Persisting:");
    System.out.println(shop);
    shopDao.insert(shop);
  }
}
