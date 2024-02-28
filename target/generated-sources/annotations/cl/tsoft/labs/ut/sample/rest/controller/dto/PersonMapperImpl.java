package cl.tsoft.labs.ut.sample.rest.controller.dto;

import cl.tsoft.labs.ut.sample.rest.entitie.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-28T14:56:59-0300",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240206-1609, environment: Java 17.0.10 (Eclipse Adoptium)"
)
public class PersonMapperImpl extends PersonMapper {

    @Override
    public PersonDto personToPersonDto(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDto.PersonDtoBuilder personDto = PersonDto.builder();

        if ( person.getBirthDate() != null ) {
            personDto.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( person.getBirthDate() ) );
        }
        personDto.cellPhone( person.getCellPhone() );
        personDto.homeAddress( person.getHomeAddress() );
        personDto.id( person.getId() );
        personDto.mail( person.getMail() );

        personDto.fullName( person.getName() + " " + person.getPaternalLastName() + " " + person.getMaternalLastName() );
        personDto.rut( person.getRut() != null ? person.getRut().toString(): null );

        return personDto.build();
    }

    @Override
    public Person personDtoToPerson(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setName( fullNameToName( personDto.getFullName() ) );
        person.setPaternalLastName( fullNameToPaternalLastName( personDto.getFullName() ) );
        person.setMaternalLastName( fullNameToMaternalLastName( personDto.getFullName() ) );
        person.setRut( rutToRut( personDto.getRut() ) );
        if ( personDto.getBirthDate() != null ) {
            person.setBirthDate( LocalDate.parse( personDto.getBirthDate() ) );
        }
        person.setCellPhone( personDto.getCellPhone() );
        person.setHomeAddress( personDto.getHomeAddress() );
        person.setId( personDto.getId() );
        person.setMail( personDto.getMail() );

        return person;
    }
}
