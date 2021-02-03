import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();

        Car car1 = new Car("Ford", new DriverHelper(fuelStation));
        Car car2 = new Car("Toyota", new DriverHelper(fuelStation));
        Car car3 = new Car("Audi", new DriverHelper(fuelStation));
        Truck truck1 = new Truck("MAN", new DriverHelper(fuelStation));
        Truck truck2 = new Truck("ZIL", new DriverHelper(fuelStation));
        Truck truck3 = new Truck("FORD", new DriverHelper(fuelStation));
        Bus bus1 = new Bus("Mercedes", new DriverHelper(fuelStation));
        Bus bus2 = new Bus("Wolksvagen", new DriverHelper(fuelStation));
        Bus bus3 = new Bus("PAZ", new DriverHelper(fuelStation));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(car1::drive);
        executorService.execute(car2::drive);
        executorService.execute(car3::drive);
        executorService.execute(truck1::drive);
        executorService.execute(truck2::drive);
        executorService.execute(truck3::drive);
        executorService.execute(bus1::drive);
        executorService.execute(bus2::drive);
        executorService.execute(bus3::drive);
    }
}
