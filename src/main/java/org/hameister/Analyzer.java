package org.hameister;

import java.time.LocalDate;

import org.hameister.personmanager.newPersonFelix;
import org.hameister.personmanager.models.Person;
import org.hameister.personmanager.repo.PersonRepository;
import org.hameister.personmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* Created by hameister on 09.01.16.
*/

@Component
public class Analyzer {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    public Analyzer(PersonRepository repository, PersonService service) {
    this.personRepository = repository;
    this.personService = service;

    if (personRepository != null) {
    System.out.println("Number of Persons in DB:" + personRepository.findAll().size());


    System.out.println("Avg. Salary:" + personService.averageSalary());


    // Insert new Person into the Database

    newPersonFelix newOne = new newPersonFelix();

    Person person = new Person();
    

    person.setName(newOne.getName());
    person.setBirthday(LocalDate.of(newOne.getBirYear(), newOne.getBirMonth(), newOne.getBirDay()));
    person.setSalary(newOne.getSalary());

    Person newPerson = personService.addPerson(person);


    /* Hier kann die neue Person hinzugefügt werden :
        Und ein erneuter Aufruf der List kann gestartet werden

*/
    if (newPerson != null) {

  System.out.println("Jetzt sollte einer mehr drin sein:" + personRepository.findAll().size());

    // Recalculate Average Salary
    System.out.println("Avg. Salary:" + personService.averageSalary());
    }

    }
    }
}