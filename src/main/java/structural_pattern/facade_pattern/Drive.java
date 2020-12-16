package structural_pattern.facade_pattern;

public class Drive {
    public static void main(String[] args) {
        Car car = new Car();
        car.goStraight();
        car.goLeft();
        car.goRight();
        car.stop();
    }
}
