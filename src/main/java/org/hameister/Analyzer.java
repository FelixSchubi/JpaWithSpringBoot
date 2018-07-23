package org.hameister;

import java.time.LocalDate;

import org.hameister.personmanager.model.Person;
import org.hameister.personmanager.repo.PersonRepository;
import org.hameister.personmanager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

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
//Felix:
        Scanner eingabe = new Scanner(System.in);

    System.out.println("Vorname der Person?");
    String newPersonVorname = eingabe.next();

    System.out.println("Nachname der Person?");
    String newPersonNachname = eingabe.next();

    String newPersonName = newPersonVorname + ' ' +  newPersonNachname;


   

  /** Meine Einngabe für neue Personen  */

    System.out.println("Wann hat die Person Geburtstag");
    System.out.println("YYYY-MM-DD");

    String newPersonBirthday = eingabe.next();

    
    String[] parts = newPersonBirthday.split("-");
    String year = parts[0]; 
    String month = parts[1]; 
    String day = parts [2];

    int intYear = Integer.parseInt(year);
    int intMonth = Integer.parseInt(month);
    int intDay = Integer.parseInt(day);


   System.out.println("Wie viel soll die Person verdienen?");
    Long newPersonSalaray = eingabe.nextLong();

    Person person = new Person();

    person.setName(newPersonName);
    person.setBirthday(LocalDate.of(intYear, intMonth, intDay));
    person.setSalary(newPersonSalaray);

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