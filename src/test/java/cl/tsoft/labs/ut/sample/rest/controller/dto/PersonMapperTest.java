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

}
