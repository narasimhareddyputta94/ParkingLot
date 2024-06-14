package stratagies;

public class ParkingSlotAllotmentStrategyFactory {
    public static ParkingPlaceAllocationStrategy getStrategy(ParkingPlaceAllocationStrategy strategyType) {
        return new SimpleParkingSlotAllotStrategy();
    }
}
