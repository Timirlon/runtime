package Lesson37_exceptions_and_files.homework.task2.validators;

import Lesson37_exceptions_and_files.homework.task2.exceptions.ValidateException;

public interface Validator {
    void validate(String value) throws ValidateException;
}
