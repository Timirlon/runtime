package Lesson21_staticFinal.homework.task2_vehicle;

public class Main {
    public static void main(String[] args) {
        AdsService adsService = new AdsService();
        VehicleAd volvoAd = new VehicleAd("Volvo", "123", new PassengerType(),
                new SedanBodyType(), new PetrolFuelType());
        VehicleAd kamazAd = new VehicleAd("Kamaz", "45", new TruckType(),
                new PickupBodyType(), new DieselFuelType());

        adsService.setAdList(new VehicleAd[] {volvoAd, kamazAd});

        adsService.filterByVehicleTypeByPurpose(new PassengerType());

        adsService.filterByVehicleTypeByPurpose(new TruckType());
    }
}
