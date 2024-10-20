package Lesson21_staticFinal.homework.task2_vehicle;

public class PassengerType extends VehicleTypeByPurpose {
    @Override
    public String getTypeName() {
        return VehicleTypeEnum.PASSENGER.name();
    }
}
