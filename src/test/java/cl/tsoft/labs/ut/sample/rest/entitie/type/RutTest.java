package cl.tsoft.labs.ut.sample.rest.entitie.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RutTest {

    @Test
    public void test_create_rut_with_valid_parameters() {
        // Arrange
        long number = 12345678;
        char digit = 'K';

        // Act
        Rut rut = new Rut(number, digit);

        // Assert
        assertEquals(number, rut.getNumber());
        assertEquals(digit, rut.getDigit());
    }
    @Test
    public void test_create_instance_with_valid_parameters() {
        // Arrange
        long number = 12345678;
        char digit = 'K';

        // Act
        Rut rut = new Rut(number, digit);

        // Assert
        assertEquals(number, rut.getNumber());
        assertEquals(digit, rut.getDigit());
    }
    @Test
    public void test_to_string_with_valid_instance() {
        // Arrange
        long number = 12345678;
        char digit = 'K';
        Rut rut = new Rut(number, digit);

        // Act
        String result = rut.toString();

        // Assert
        assertEquals(number + "-" + digit, result);
    }
    @Test
    public void test_value_of_with_valid_string() {
        // Arrange
        String rutString = "12345678-K";
        long expectedNumber = 12345678;
        char expectedDigit = 'K';

        // Act
        Rut rut = Rut.valueOf(rutString);

        // Assert
        assertNotNull(rut);
        assertEquals(expectedNumber, rut.getNumber());
        assertEquals(expectedDigit, rut.getDigit());

    }

    @Test
    public void test_valid_number_and_digit_combination() {
        // Arrange
        long number = 12345678;
        char digit = 'K';
        Rut rut = new Rut(number, digit);

        // Act
        boolean result = rut.isValid();

        // Assert
        assertEquals(true, !result);
    }
    @Test
    public void test_invalid_number_and_digit_combination() {
        // Arrange
        long number = 12345678;
        char digit = '0';
        Rut rut = new Rut(number, digit);

        // Act
        boolean result = rut.isValid();

        // Assert
        assertFalse(result);
    }
    @Test
    public void test_number_greater_than_max() {
        // Arrange
        long number = 100000000;
        char digit = 'K';
        Rut rut = new Rut(number, digit);

        // Act
        boolean result = rut.isValid();

        // Assert
        assertFalse(result);
    }

    @Test
    public void test_number_less_than_or_equal_to_zero() {
        // Arrange
        long number = 0;
        char digit = 'K';
        Rut rut = new Rut(number, digit);

        // Act
        boolean result = rut.isValid();

        // Assert
        assertFalse(result);
    }
    @Test
    public void test_minimum_valid_number_and_digit_combination() {
        // Arrange
        long number = 1;
        char digit = '0';
        Rut rut = new Rut(number, digit);

        // Act
        boolean result = rut.isValid();

        // Assert
        assertFalse(result);
    }
    @Test
    public void test_maximum_valid_number_and_digit_combination() {
        // Arrange
        long number = 99999999;
        char digit = 'K';
        Rut rut = new Rut(number, digit);

        // Act
        boolean result = rut.isValid();

        // Assert
        assertFalse(result);
    }
}
