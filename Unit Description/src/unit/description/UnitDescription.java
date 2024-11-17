package unit.description;

import java.util.ArrayList;
import java.util.List;

public class UnitDescription {
    private int unitID;
    private int capacity;
    private UnitType unitType;
    private int floor;
    private double rentAmount;
    private UnitStatus status;

    public enum UnitType {
        STUDIO, ONE_BEDROOM, TWO_BEDROOM, PENTHOUSE, THREE_BEDROOM;
    }

    public enum UnitStatus {
        AVAILABLE, OCCUPIED, UNDER_MAINTENANCE;
    }

    public UnitDescription(int unitID, int capacity, UnitType unitType, int floor, double rentAmount, UnitStatus status) {
        this.unitID = unitID;
        this.capacity = capacity;
        this.unitType = unitType;
        this.floor = floor;
        this.rentAmount = rentAmount;
        this.status = status;
    }

    public int getUnitID() { return unitID; }
    public int getCapacity() { return capacity; }
    public UnitType getUnitType() { return unitType; }
    public int getFloor() { return floor; }
    public double getRentAmount() { return rentAmount; }
    public UnitStatus getStatus() { return status; }

    public void setUnitID(int unitID) { this.unitID = unitID; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setUnitType(UnitType unitType) { this.unitType = unitType; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setRentAmount(double rentAmount) { this.rentAmount = rentAmount; }
    public void setStatus(UnitStatus status) { this.status = status; }

    public String getDetails() {
        return String.format("Unit ID: %d, Capacity: %d, Unit Type: %s, Floor: %d, Rent Amount: %.2f, Status: %s",
                             unitID, capacity, unitType, floor, rentAmount, status);
    }

    public boolean checkAvail() {
        return status == UnitStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return getDetails();
    }

    // New static method to display initial units
    public static void displayInitialUnits() {
        List<UnitDescription> initialUnits = new ArrayList<>();
        initialUnits.add(new UnitDescription(101, 2, UnitType.ONE_BEDROOM, 1, 1200.0, UnitStatus.AVAILABLE));
        initialUnits.add(new UnitDescription(102, 3, UnitType.TWO_BEDROOM, 2, 1500.0, UnitStatus.OCCUPIED));
        initialUnits.add(new UnitDescription(201, 1, UnitType.STUDIO, 2, 900.0, UnitStatus.AVAILABLE));
        initialUnits.add(new UnitDescription(301, 4, UnitType.PENTHOUSE, 3, 3000.0, UnitStatus.UNDER_MAINTENANCE));

        System.out.println("Initial Apartment Units:");
        for (UnitDescription unit : initialUnits) {
            System.out.println(unit.getDetails());
        }
        System.out.println();
    }
}