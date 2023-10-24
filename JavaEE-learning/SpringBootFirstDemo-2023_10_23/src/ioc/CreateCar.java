package ioc;



public class CreateCar {
    public static void main(String[] args) {
        // 造轮胎
        Tire tire = new Tire(150, "blue");
        Bottom bottom = new Bottom(tire);
        Frame frame = new Frame(bottom);
        Car car = new ioc.Car(frame);
        car.init();

    }
}
