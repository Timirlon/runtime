package Lesson21_staticFinal.homework.task2_vehicle;

public class VehicleTypeByFuelTypes extends VehicleType {
    public VehicleTypeByFuelTypes () {
        super("Vehicle type by Fuel types");
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        VehicleTypeByFuelTypes that = (VehicleTypeByFuelTypes) object;
        return attribute != null ? attribute.equals(that.attribute) : false;
    }
}

