package Lesson21_staticFinal.homework.task2_vehicle;

public class SedanBodyType extends VehicleTypeByBody {
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.SEDAN.name();
    }
}
