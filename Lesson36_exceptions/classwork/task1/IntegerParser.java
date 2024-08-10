package Lesson36_exceptions.classwork.task1;

import java.math.BigInteger;

public class IntegerParser {
    public static int parseInt(String inputValue) {
        if (inputValue.trim().isEmpty()) {
            throw new EmptyStringException();
        }

        if (!inputValue.matches("-?\\d+")) {
            throw new StringNotNumberException();
        }

        BigInteger value = new BigInteger(inputValue);
        if (value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new StringIsTooBigNumberException();
        }

        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            throw new StringIsTooSmallNumberException();
        }

        return Integer.parseInt(inputValue);
    }
}

class EmptyStringException extends RuntimeException {
}

class StringIsTooSmallNumberException extends RuntimeException {
}

class StringIsTooBigNumberException extends RuntimeException {
}

class StringNotNumberException extends RuntimeException {
}
