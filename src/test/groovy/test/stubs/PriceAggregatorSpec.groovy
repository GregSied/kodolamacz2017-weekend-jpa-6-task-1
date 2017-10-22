package test.stubs

import spock.lang.Specification
import spock.lang.Subject


class PriceAggregatorSpec extends Specification {

  @Subject
  PriceAggregator priceAggregator = new PriceAggregator()

  def "should sum product prices"() {
    given:
    Product left = Stub(Product) {
      getPrice() >> 2
    }
    Product right = Stub(Product) {
      getPrice() >> 3
    }
    and:
    def expectedPrice = 5

    when:
    def actualPrice = priceAggregator.sum(left, right)

    then:
    actualPrice == expectedPrice
  }

}
