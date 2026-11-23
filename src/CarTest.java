public class CarTest {

    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }


    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();

        fastSaab.setTurboOn();
        slowSaab.setTurboOff();

        fastSaab.gas(0.5);
        slowSaab.gas(0.5);

        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();

        reportResult("Turbo yields more speed", result);
    }



    private static void testGas() {
        Volvo240 volvo = new Volvo240();

        volvo.startEngine();

        double oldSpeed = volvo.getCurrentSpeed();

        // Test that 1 is accepted
        volvo.gas(1);

        boolean validResult = volvo.getCurrentSpeed() > oldSpeed;

        reportResult("Gas amount 1 works", validResult);

        // Test that 2 is rejected
        double currentSpeed = volvo.getCurrentSpeed();

        volvo.gas(2);

        boolean invalidResult = volvo.getCurrentSpeed() == currentSpeed;

        reportResult("Invalid gas amount does not change speed", invalidResult);
    }
    private static void testturnleft(){
        Volvo240 volvo = new Volvo240();
        volvo.turnLeft();
        boolean validResult = volvo.getDirection() == 3;
        reportResult("volvo truns left",  validResult );
    }
    private static void testtrimfactor(){
        Volvo240 volvo = new Volvo240();
        double oldspeed = volvo.getCurrentSpeed();
        double gas= 0.5;
        volvo.gas(gas);
        double result = volvo.getCurrentSpeed() - oldspeed;
        boolean validResult = result == volvo.speedFactor() * gas;
        reportResult("trimfactor result",validResult);
    }
    public static void main(String[] args) {
        testTurbo();
        testGas();
        testturnleft();
        testtrimfactor();
    }
}