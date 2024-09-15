package Lesson47_unit_test_part3.classwork.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkVendingMachineTest{
    @Test
    public void shouldThrowExceptionIfInvalidValueWhileInsertingCoin() {
        DrinkVendingMachine vendingMachine = new DrinkVendingMachine();

        assertThrows(IllegalArgumentException.class, () -> vendingMachine.insertCoin(-5));
    }

    @Test
    public void shouldInsertCoinSuccessfullyIfValuePositive() {
        DrinkVendingMachine vendingMachine = new DrinkVendingMachine();

        vendingMachine.insertCoin(10);

        assertEquals(10, vendingMachine.getBalance());
    }

    @Test
    public void shouldReturnMessageIfSelectedDrinkAbsent() {
        DrinkVendingMachine vendingMachine = new DrinkVendingMachine();

        assertEquals("Такого напитка нет в автомате.", vendingMachine.selectDrink("Миринда"));
    }

    @Test
    public void shouldReturnMessageIfRanOutOfSelectedDrink() {
        DrinkVendingMachine vendingMachine = new DrinkVendingMachine();

        vendingMachine.insertCoin(1500);
        String returnValue = "";
        String drinkName = "Фанта";

        for (int i = 0; i < 6; i++) {
            returnValue = vendingMachine.selectDrink(drinkName);
        }

        assertEquals("Извините, " + drinkName + " закончился.", returnValue);
    }

    @Test
    public void shouldReturnMessageIfInsufficientFundsWhenSelectingDrink() {
        DrinkVendingMachine vendingMachine = new DrinkVendingMachine();

        vendingMachine.insertCoin(150);

        assertEquals("Недостаточно средств.", vendingMachine.selectDrink("Фанта"));
    }

    @Test
    public void shouldReturnMessageIfDrinkSelectedSuccessfully() {
        DrinkVendingMachine vendingMachine = new DrinkVendingMachine();

        vendingMachine.insertCoin(500);
        String drinkName = "Кола";

        assertEquals("Вы получили " + drinkName + "!", vendingMachine.selectDrink(drinkName));
    }

    @Test
    public void shouldReturnDrinkQuantity() {
        DrinkVendingMachine vendingMachine = new DrinkVendingMachine();

        assertEquals(10, vendingMachine.getDrinkQuantity("Кола"));
    }
}
