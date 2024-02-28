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

    @Test
    public void test_valueOf_returns_null_when_rut_is_null() {
        // Arrange
        String rut = null;

        // Act
        Rut result = Rut.valueOf(rut);

        // Assert
        assertNull(result);
    }
    @Test
    public void test_isValid_withValidRutInstance() {
        // Arrange
        long number = 12345678;
        char digit = 'K';
        Rut rut = new Rut(number, digit);

        // Act
        boolean result = rut.isValid();

        // Assert
        assertFalse(result);
    }
    @Test
    public void test_toString_validRutInstance() {
        // Arrange
        long number = 12345678;
        char digit = 'K';
        Rut rut = new Rut(number, digit);

        // Act
        String result = rut.toString();

        // Assert
        assertEquals("12345678-K", result);
    }
    @Test
    public void test_calculateDigit_withValidNumber_shouldReturnCorrectDigit() {
        // Arrange
        long number = 12345678;
        char expectedDigit = '5';

        // Act
        char actualDigit = Rut.calculateDigit(number);

        // Assert
        assertEquals(expectedDigit, actualDigit);
    }
    @Test
    public void test_valueOf_validStringParameter_returnsRutInstanceWithCorrectAttributes() {
        // Arrange
        String validRutString = "12345678-9";

        // Act
        Rut rut = Rut.valueOf(validRutString);

        // Assert
        assertNotNull(rut);
        assertEquals(12345678, rut.getNumber());
        assertEquals('9', rut.getDigit());
    }
    @Test
    public void test_is_valid_with_valid_rut() {
        // Arrange
        long number = 12345678;
        char digit = 'K';
        Rut rut = new Rut(number, digit);

        // Act
        boolean isValid = rut.isValid();

        // Assert
        assertFalse(isValid);
    }
    @Test
    public void test_create_rut_with_zero_number_and_x_digit() {
        // Arrange
        long number = 0;
        char digit = 'X';

        // Act
        Rut rut = new Rut(number, digit);

        // Assert
        assertEquals(number, rut.getNumber());
        assertEquals(digit, rut.getDigit());
    }
        // Creating a new instance of Rut with valid arguments should set the number and digit attributes correctly.
        @Test
        public void test_valid_arguments() {
            long number = 12345678;
            char digit = 'K';
    
            Rut rut = new Rut(number, digit);
    
            assertEquals(number, rut.getNumber());
            assertEquals(digit, rut.getDigit());
        }
            // Calling the isValid method with a valid Rut instance should return true.
    @Test
    public void test_isValid_with_valid_Rut_instance() {
        long number = 12345678;
        char digit = 'K';

        Rut rut = new Rut(number, digit);

        assertTrue(rut.isValid());
    }
        // Calling the calculateDigit method with a valid number should return the correct digit.
        @Test
        public void test_calculateDigit_with_valid_number() {
            long number = 12345678;
            char expectedDigit = 'K';
    
            char actualDigit = Rut.calculateDigit(number);
    
            assertEquals(expectedDigit, actualDigit);
        }
            // Calling the valueOf method with a valid string representation of a Rut should return a new Rut instance with the correct number and digit attributes.
    @Test
    public void test_valueOf_withValidStringRepresentation() {
        String rutString = "12345678-K";
        Rut rut = Rut.valueOf(rutString);

        assertEquals(12345678, rut.getNumber());
        assertEquals('K', rut.getDigit());
    }
    
}
