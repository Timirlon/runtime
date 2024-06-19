package Lesson21_staticFinal.homework.task2_vehicle;

public class WagonBodyType extends VehicleTypeByBody {
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.WAGON.name();
    }
}
