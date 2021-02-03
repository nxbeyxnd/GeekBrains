public class DriverHelper {
    private final FuelStation fuelStation;

    public DriverHelper(FuelStation fuelStation) {
        this.fuelStation = fuelStation;
    }

    public float refuel(float request){
        return fuelStation.refuel(request);
    }
}
