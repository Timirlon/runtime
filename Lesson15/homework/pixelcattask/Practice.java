package Lesson15.homework.pixelcattask;

public class Practice {
    public static void main(String[] args) {
        String pixelKcalDay = "43"; // столько калорий съел Пиксель до похода к бабушке
        String beefKcal = "30.2"; // калорийность говядины
        String chickenKcal = "23.8"; // калорийность курицы
        String creamKcal = "32.1"; // калорийность сливок
        String milkKcal = "13.5"; // калорийность молока

        float pixelChoice = getMinKcalsSum(beefKcal, chickenKcal, creamKcal, milkKcal);
        float totalKcal = Integer.parseInt(pixelKcalDay) + pixelChoice;
        checkKcal(totalKcal);
    }

    private static Float getMinKcalsSum(String firstDishKcal, String secondDishKcal, String firstDesert, String secondDesert) {
        float minDishKcal;
        float minDesertKcal;

        if (Float.parseFloat(firstDishKcal) < Float.parseFloat(secondDishKcal)) {
            minDishKcal = Float.parseFloat(firstDishKcal);
        } else {
            minDishKcal = Float.parseFloat(secondDishKcal);
        }

        if (Float.parseFloat(firstDesert) < Float.parseFloat(secondDesert)) {
            minDesertKcal = Float.parseFloat(firstDesert);
        } else {
            minDesertKcal = Float.parseFloat(secondDesert);
        }
        return minDishKcal + minDesertKcal;
    }

    private static void checkKcal(float catKcal) {
        if (catKcal == 0) {
            System.out.println("Что-то пошло не так");
        } else {
            System.out.println("Калорийность рациона Пикселя за день: " + catKcal);
            if (catKcal > 100) {
                System.out.println("Пиксель сегодня не уложился в норму.");
            } else {
                System.out.println("Лимит не превышен!");
            }
        }
    }
}
