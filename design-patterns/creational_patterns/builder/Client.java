package creational_patterns.builder;

public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder carManualBuilder = new CarManualBuilder();
        director.constructSportsCar(carManualBuilder);
        Manual carManual = carManualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

    }
}
