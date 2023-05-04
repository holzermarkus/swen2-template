package at.fhtw.swen2.tutorial.persistence;

import at.fhtw.swen2.tutorial.persistence.entities.PersonEntity;
import at.fhtw.swen2.tutorial.persistence.repositories.PersonRepository;
import at.fhtw.swen2.tutorial.service.dto.Person;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInitializer implements InitializingBean {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        personRepository.saveAll(getInitialDemoData());
    }

    public static List<PersonEntity> getInitialDemoData() {
        List<PersonEntity> personList = new ArrayList<>();
        personList.add(PersonEntity.builder().id(5L).name("John").isEmployed(true).build());
        personList.add(PersonEntity.builder().id(7L).name("Albert").isEmployed(true).build());
        personList.add(PersonEntity.builder().id(11L).name("Monica").isEmployed(true).build());
        return personList;
    }
    public static List<Person> getInitialDemoDataDtos() {
        List<Person> personList = new ArrayList<>();
        personList.add(Person.builder().id(5L).name("John").isEmployed(true).build());
        personList.add(Person.builder().id(7L).name("Albert").isEmployed(true).build());
        personList.add(Person.builder().id(11L).name("Monica").isEmployed(true).build());
        return personList;
    }
}
