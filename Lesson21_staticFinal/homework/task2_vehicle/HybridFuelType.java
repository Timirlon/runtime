package Lesson21_staticFinal.homework.task2_vehicle;

public class HybridFuelType extends VehicleTypeByFuelTypes {
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.HYBRID.name();
    }
}
