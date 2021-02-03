public class Car implements Transport{
    private final float fuelMaxCapacity = 20F;
    private final float fuelConsumption = 2.5F;
    private float fuelCapacity = fuelMaxCapacity;

    private String brand;

    private DriverHelper driverHelper;

    public Car(String brand, DriverHelper driverHelper) {
        this.brand = brand;
        this.driverHelper = driverHelper;
    }

    public void drive(){
        try {
            while(fuelCapacity > 0) {
                if (fuelCapacity <= fuelConsumption * 2){
                    driveToFuelStation();
                }
                fuelCapacity -= fuelConsumption;
                Thread.sleep(3000);
                System.out.println(this + "\n" + "Type: " + getClass().getName().toString() + "\n Thread:" + Thread.currentThread().getName().toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void driveToFuelStation (){
        fuelCapacity = fuelCapacity + driverHelper.refuel(fuelMaxCapacity - fuelCapacity);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Truck{" +
                "fuelMaxCapacity=" + fuelMaxCapacity +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelCapacity=" + fuelCapacity +
                ", brand='" + brand + '\'' +
                '}';
    }
}
