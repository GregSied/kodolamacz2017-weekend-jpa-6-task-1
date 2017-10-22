package test.stubs

class PriceAggregator {
  int sum(Product left, Product right) {
    return left.price + right.price
  }
}
