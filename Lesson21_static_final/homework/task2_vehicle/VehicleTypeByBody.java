package Lesson21_staticFinal.homework.task2_vehicle;

public class VehicleTypeByBody extends VehicleType {
    public VehicleTypeByBody () {
        super("Vehicle type by body");
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        VehicleTypeByBody that = (VehicleTypeByBody) object;
        return attribute != null ? attribute.equals(that.attribute) : false;
    }
}
