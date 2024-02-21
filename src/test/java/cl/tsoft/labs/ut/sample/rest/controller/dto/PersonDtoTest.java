package cl.tsoft.labs.ut.sample.rest.controller.dto;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDtoTest {

    @Test
    public void test_create_personDto_with_all_fields() {
        // Given
        String rut = "60212830-K";
        String fullName = "JOHN DOE LUCAS";
        String birthDate = "1980-03-01";
        String homeAddress = "THE ADDRESS";
        String cellPhone = "+5692191920";
        String mail = "john.doe.lucas@gmail.com";

        // When
        PersonDto personDto = PersonDto.builder()
                .rut(rut)
                .fullName(fullName)
                .birthDate(birthDate)
                .homeAddress(homeAddress)
                .cellPhone(cellPhone)
                .mail(mail)
                .build();

        // Then
        assertNotNull(personDto);
        assertEquals(rut, personDto.getRut());
        assertEquals(fullName, personDto.getFullName());
        assertEquals(birthDate, personDto.getBirthDate());
        assertEquals(homeAddress, personDto.getHomeAddress());
        assertEquals(cellPhone, personDto.getCellPhone());
        assertEquals(mail, personDto.getMail());
    }

    @Test
    public void test_create_personDto_with_required_fields() {
        // Given
        String rut = "60212830-K";
        String fullName = "JOHN DOE LUCAS";

        // When
        PersonDto personDto = PersonDto.builder()
                .rut(rut)
                .fullName(fullName)
                .build();

        // Then
        assertNotNull(personDto);
        assertEquals(rut, personDto.getRut());
        assertEquals(fullName, personDto.getFullName());
        assertNull(personDto.getBirthDate());
        assertNull(personDto.getHomeAddress());
        assertNull(personDto.getCellPhone());
        assertNull(personDto.getMail());
    }

    @Test
    public void test_deserialize_json_to_persondto() {
        // Given
        String json = "{\"id\": 1, \"rut\": \"60212830-K\", \"fullName\": \"JOHN DOE LUCAS\", \"birthDate\": \"1980-03-01\", \"homeAddress\": \"THE ADDRESS\", \"cellPhone\": \"+5692191920\", \"mail\": \"john.doe.lucas@gmail.com\"}";

        // When
        PersonDto personDto = new Gson().fromJson(json, PersonDto.class);

        // Then
        assertEquals(1L, personDto.getId());
        assertEquals("60212830-K", personDto.getRut());
        assertEquals("JOHN DOE LUCAS", personDto.getFullName());
        assertEquals("1980-03-01", personDto.getBirthDate());
        assertEquals("THE ADDRESS", personDto.getHomeAddress());
        assertEquals("+5692191920", personDto.getCellPhone());
        assertEquals("john.doe.lucas@gmail.com", personDto.getMail());
    }
    @Test
    public void test_compare_equal_person_dto_instances() {
        // Given
        PersonDto personDto1 = PersonDto.builder()
                .id(1L)
                .rut("60212830-K")
                .fullName("JOHN DOE LUCAS")
                .birthDate("1980-03-01")
                .homeAddress("THE ADDRESS")
                .cellPhone("+5692191920")
                .mail("john.doe.lucas@gmail.com")
                .build();

        PersonDto personDto2 = PersonDto.builder()
                .id(1L)
                .rut("60212830-K")
                .fullName("JOHN DOE LUCAS")
                .birthDate("1980-03-01")
                .homeAddress("THE ADDRESS")
                .cellPhone("+5692191920")
                .mail("john.doe.lucas@gmail.com")
                .build();

        // When
        boolean result = personDto1.equals(personDto2);

        // Then
        assertTrue(result);
    }
}
