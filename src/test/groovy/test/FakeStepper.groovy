package test

class FakeStepper extends Stepper {
  @Override
  void step() {
    Thread.sleep(2000)
  }
}
