import java.awt.Color;

public abstract class Car implements Movable {

    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getModelName() {
        return modelName;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);

            if (currentSpeed > enginePower) {
                currentSpeed = enginePower;
            }
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);

            if (currentSpeed < 0) {
                currentSpeed = 0;
            }
        }
    }

    protected double x = 0;
    protected double y = 0;
    protected int direction = 0;

    @Override
    public void move() {
        switch(direction) {
            case 0:
                y += currentSpeed;
                break;
            case 1:
                x += currentSpeed;
                break;
            case 2:
                y -= currentSpeed;
                break;
            case 3:
                x -= currentSpeed;
                break;
        }
    }

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4;
    }

    @Override
    public  void turnRight() {
        direction = (direction + 1) % 4;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }
}
