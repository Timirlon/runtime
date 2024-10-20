package Lesson21_staticFinal.homework.task2_vehicle;

public class PetrolFuelType extends VehicleTypeByFuelTypes {
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.PETROL.name();
    }
}
