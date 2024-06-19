package Lesson21_staticFinal.homework.task2_vehicle;

public class ElectricFuelType extends VehicleTypeByFuelTypes {
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.ELECTRIC.name();
    }
}
