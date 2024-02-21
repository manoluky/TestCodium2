package cl.tsoft.labs.ut.sample.rest.controller.dto;

import cl.tsoft.labs.ut.sample.rest.entitie.Person;
import cl.tsoft.labs.ut.sample.rest.entitie.type.Rut;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PersonMapperTest {

    @Test
    public void test_mapping_from_person_to_persondto() {
        // Arrange
        Person person = new Person();
        person.setId(1L);
        person.setRut(new Rut(12345678, 'K'));
        person.setName("John");
        person.setPaternalLastName("Doe");
        person.setMaternalLastName("Smith");
        person.setBirthDate(LocalDate.of(1990, 1, 1));
        person.setHomeAddress("123 Main St");
        person.setCellPhone("555-1234");
        person.setMail("john.doe@example.com");

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertEquals(person.getId(), personDto.getId());
        assertEquals(person.getRut().toString(), personDto.getRut());
        assertEquals(person.getName() + " " + person.getPaternalLastName() + " " + person.getMaternalLastName(), personDto.getFullName());
        assertEquals(person.getBirthDate().format(DateTimeFormatter.ISO_LOCAL_DATE), personDto.getBirthDate());
        assertEquals(person.getHomeAddress(), personDto.getHomeAddress());
        assertEquals(person.getCellPhone(), personDto.getCellPhone());
        assertEquals(person.getMail(), personDto.getMail());
    }
    @Test
    public void test_mapping_from_persondto_to_person() {
        // Arrange
        PersonDto personDto = PersonDto.builder()
                .id(1L)
                .rut("12345678-K")
                .fullName("John Doe Smith")
                .birthDate("1990-01-01")
                .homeAddress("123 Main St")
                .cellPhone("555-1234")
                .mail("john.doe@example.com")
                .build();

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        Person person = mapper.personDtoToPerson(personDto);

        // Assert
        assertEquals(personDto.getId(), person.getId());
        assertEquals(new Rut(12345678, 'K'), person.getRut());
        assertEquals("John", person.getName());
        assertEquals("Doe", person.getPaternalLastName());
        assertEquals("Smith", person.getMaternalLastName());
        assertEquals(LocalDate.of(1990, 1, 1), person.getBirthDate());
        assertEquals(personDto.getHomeAddress(), person.getHomeAddress());
        assertEquals(personDto.getCellPhone(), person.getCellPhone());
        assertEquals(personDto.getMail(), person.getMail());
    }
    @Test
    public void test_mapping_person_with_null_fields_to_persondto() {
        // Arrange
        Person person = new Person();

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertNull(personDto.getId());
        assertNull(personDto.getRut());
        assertNull(personDto.getFullName());
        assertNull(personDto.getBirthDate());
        assertNull(personDto.getHomeAddress());
        assertNull(personDto.getCellPhone());
        assertNull(personDto.getMail());
    }
    @Test
    public void test_mapping_persondto_with_null_fields_to_person() {
        // Arrange
        PersonDto personDto = new PersonDto();

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        Person person = mapper.personDtoToPerson(personDto);

        // Assert
        assertNull(person.getId());
        assertNull(person.getRut());
        assertNull(person.getName());
        assertNull(person.getPaternalLastName());
        assertNull(person.getMaternalLastName());
        assertNull(person.getBirthDate());
        assertNull(person.getHomeAddress());
        assertNull(person.getCellPhone());
        assertNull(person.getMail());
    }
    @Test
    public void test_mapping_person_with_empty_fields_to_persondto() {
        // Arrange
        Person person = new Person();
        person.setId(1L);
        person.setRut(new Rut(12345678, 'K'));
        person.setName("");
        person.setPaternalLastName("");
        person.setMaternalLastName("");
        person.setBirthDate(null);
        person.setHomeAddress("");
        person.setCellPhone("");
        person.setMail("");

        PersonMapperImpl mapper = new PersonMapperImpl();

        // Act
        PersonDto personDto = mapper.personToPersonDto(person);

        // Assert
        assertEquals(person.getId(), personDto.getId());
        assertEquals(person.getRut().toString(), personDto.getRut());
        assertEquals("", personDto.getFullName());
        assertNull(personDto.getBirthDate());
        assertEquals("", personDto.getHomeAddress());
        assertEquals("", personDto.getCellPhone());
        assertEquals("", personDto.getMail());
    }
}
