void main() {
    // Instance of this class
    CarController cc = new CarController();

    // TODO uncomment, and adapt if necessary
    cc.cars.add(new Volvo240());

    Saab95 saab = new Saab95();
    saab.setX(200);
    cc.cars.add(saab);

    // Start a new view and send a reference to the controller
    cc.frame = new CarView("CarSim 1.0", cc);
    cc.startTimer();
}