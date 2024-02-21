package cl.tsoft.labs.ut.sample.rest.entitie.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RutTest {
    @Test
    public void test_create_rut_with_valid_number_and_digit() {
        long number = 12345678;
        char digit = 'K';

        Rut rut = new Rut(number, digit);

        assertEquals(number, rut.getNumber());
        assertEquals(digit, rut.getDigit());
    }
    @Test
    public void test_is_valid_with_valid_rut() {
        long number = 12345678;
        char digit = 'K';

        Rut rut = new Rut(number, digit);

        assertTrue(rut.isValid());
    }
    @Test
    public void test_calculate_digit_with_valid_number() {
        long number = 12345678;
        char expectedDigit = 'K';

        char calculatedDigit = Rut.calculateDigit(number);


        assertEquals(expectedDigit, calculatedDigit);
    }

    @Test
    public void test_value_of_with_valid_string_representation() {
        String rutText = "12345678-K";
        long expectedNumber = 12345678;
        char expectedDigit = 'K';

        Rut rut = Rut.valueOf(rutText);

        assertEquals(expectedNumber, rut.getNumber());
        assertEquals(expectedDigit, rut.getDigit());
    }
    @Test
    public void test_to_string_with_valid_rut() {
        long number = 12345678;
        char digit = 'K';
        String expectedString = "12345678-K";

        Rut rut = new Rut(number, digit);

        assertEquals(expectedString, rut.toString());
    }


}