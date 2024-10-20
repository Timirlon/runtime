package Lesson21_staticFinal.homework.task2_vehicle;

public class PickupBodyType extends VehicleTypeByBody {
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.PICKUP.name();
    }
}
