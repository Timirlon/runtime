package Lesson45_unit_test.classwork.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void shouldNotBeBlockedWhenCreated() {
        BankAccount account = new BankAccount("a", "b");
        assertFalse(account.isBlocked());
    }

    @Test
    public void shouldReturnZeroAmountAfterActivation() {
        BankAccount account = new BankAccount("a", "b");
        account.activate("KZT");
        assertEquals(0, account.getAmount());
        assertEquals("KZT", account.getCurrency());
    }

    @Test
    public void shouldBeBlockedAfterBlockIsCalled() {
        BankAccount account = new BankAccount("А", "Б");
        account.block();
        assertTrue(account.isBlocked());
    }

    @Test
    public void shouldReturnFirstNameThenSecondName() {
        BankAccount account = new BankAccount("Амиров", "Бекзот");
        String[] fullName = {"Амиров", "Бекзот"};
        assertArrayEquals(fullName, account.getFullName());
    }

    @Test
    public void shouldReturnNullAmountWhenNotActive() {
        BankAccount account = new BankAccount("A", "B");

        assertThrows(IllegalStateException.class, account::getAmount);
        assertNull(account.getCurrency());
    }

    @Test
    public void shouldThrowExceptionIfNotActiveDuringWithdraw() {
        BankAccount account = new BankAccount("A", "B");

        assertThrows(IllegalStateException.class, () -> account.withdraw(100));
    }

    @Test
    public void shouldThrowExceptionIfInsufficientFundsDuringWithdraw() {
        BankAccount account = new BankAccount("A", "B");

        account.activate("KZT");

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.withdraw(100));

        assertEquals("Недостаточно средств для транзакции.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionIfAccountBlockedDuringWithdraw() {
        BankAccount account = new BankAccount("A", "B");

        account.activate("KZT");
        account.addToBalance(200);
        account.block();

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> account.withdraw(100));

        assertEquals("Счёт заблокирован.", exception.getMessage());
    }

    @Test
    public void shouldWithdrawSuccessfullyIfConditionsAreMet() {
        BankAccount account = new BankAccount("A", "B");

        account.activate("KZT");
        account.addToBalance(200);
        account.withdraw(100);

        assertEquals(100, account.getAmount());
    }

    @Test
    public void shouldThrowExceptionIfTransferorNotActivatedDuringTransfer() {
        BankAccount transferor = new BankAccount("Омир", "Джон");
        BankAccount recipient = new BankAccount("Оли", "Бэк");

        assertThrows(IllegalStateException.class, () -> transferor.transfer(recipient, 200));
    }

    @Test
    public void shouldThrowExceptionIfInvalidAmountGivenDuringTransfer() {
        BankAccount transferor = new BankAccount("Омир", "Джон");
        BankAccount recipient = new BankAccount("Оли", "Бэк");

        transferor.activate("KZT");

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> transferor.transfer(recipient, -10));

        assertEquals("Введена некорректная сумма для перевода.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionIfInsufficientFundsDuringTransfer() {
        BankAccount transferor = new BankAccount("Омир", "Джон");
        BankAccount recipient = new BankAccount("Оли", "Бэк");

        transferor.activate("KZT");

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> transferor.transfer(recipient, 200));

        assertEquals("Недостаточно средств для транзакции.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionIfTransferorBlockedDuringTransfer() {
        BankAccount transferor = new BankAccount("Омир", "Джон");
        BankAccount recipient = new BankAccount("Оли", "Бэк");

        transferor.activate("KZT");
        transferor.addToBalance(500);

        transferor.block();

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> transferor.transfer(recipient, 200));

        assertEquals("Ваш счёт заблокирован.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionIfRecipientNotActivatedDuringTransfer() {
        BankAccount transferor = new BankAccount("Омир", "Джон");
        BankAccount recipient = new BankAccount("Оли", "Бэк");

        transferor.activate("KZT");
        transferor.addToBalance(500);


        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> transferor.transfer(recipient, 200));

        assertEquals("Cчёт получателя не активирован.", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionIfRecipientBlockedDuringTransfer() {
        BankAccount transferor = new BankAccount("Омир", "Джон");
        BankAccount recipient = new BankAccount("Оли", "Бэк");

        transferor.activate("KZT");
        transferor.addToBalance(500);

        recipient.activate("KZT");
        recipient.block();

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> transferor.transfer(recipient, 200));

        assertEquals("Cчёт получателя заблокирован.", exception.getMessage());
    }

    @Test
    public void shouldTransferSuccessfullyIfConditionsAreMet() {
        BankAccount transferor = new BankAccount("Омир", "Джон");
        BankAccount recipient = new BankAccount("Оли", "Бэк");

        transferor.activate("KZT");
        transferor.addToBalance(500);

        recipient.activate("KZT");

        transferor.transfer(recipient, 200);

        assertEquals(300, transferor.getAmount());
        assertEquals(200, recipient.getAmount());
    }
}
