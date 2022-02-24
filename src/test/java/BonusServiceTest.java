import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
        //Тест-кейс1: Пользователь зарегистрирован, сумма меньше лимита
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
        //Тест-кейс2: Пользователь зарегистрирован, сумма выше лимита
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
        //Тест-кейс3: Пользователь не зарегистрирован, сумма ниже лимита
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
        //Тест-кейс4: Пользователь не зарегистрирован, сумма выше лимита
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}