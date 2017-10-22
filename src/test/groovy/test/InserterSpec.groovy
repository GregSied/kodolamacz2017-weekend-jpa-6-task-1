package test

import spock.lang.Specification

class InserterSpec extends Specification {

  // fake objects
  Stepper anonFakeStepper = new Stepper() {
    @Override
    public void step() {
      Thread.sleep(2000)
    }
  }

  Stepper namedFakeStepper = new FakeStepper()

  // stub objects
  Stepper stubStepper = Stub() {
    step() >> Thread.sleep(2000)
  }

  Stepper stubStepper2 = Stub()

  // mock objects
  Stepper mockStepper = Mock() {
    step() >> Thread.sleep(2000)
  }

  Stepper mockStepper2 = Mock()

  def "should step and insert"() {
    given:
    def stepper = Mock(Stepper)
    def shopDao = Mock(ShopDao)
    def inserter = new Inserter(stepper, shopDao)

    when:
    inserter.insert()
    inserter.insert()

    then:
    1 * stepper.step()
    1 * shopDao.insert(_)
  }

}
