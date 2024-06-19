package Lesson21_staticFinal.homework.task2_vehicle;

public class CarType extends VehicleTypeByPurpose {
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.CAR.name();
    }
}
