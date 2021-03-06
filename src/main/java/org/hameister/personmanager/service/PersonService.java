package org.hameister.personmanager.service;
 
import org.hameister.personmanager.models.Person;
import org.hameister.personmanager.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.time.format.DateTimeFormatter;
import java.util.List;
 
/**
 * Created by hameister on 23.01.16.
 */
@Service
public class PersonService {
 
 
    @Autowired
    PersonRepository personRepository;
 
    public double  averageSalary() {
 
        double salarySum = 0;
        List<Person> personList= personRepository.findAll();
 
        for( Person person : personList) {
 
            salarySum =  salarySum +person.getSalary();
 
 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
 
            if(person.getBirthday()!=null) {
                String birthday = person.getBirthday().format(formatter);
                System.out.println("Der Geburtstag von " + person.getName() + " ist: " + birthday+ " und der Verdienst ist:"+ person.getSalary());
                System.out.println("Hier kommt der Test:" + person.getA61());
            }
            String x = "**************************************************************";
			System.out.println(x);
        }
 
        return  salarySum / personList.size();
    }
 
    public Person  addPerson(Person person) {
 
        return personRepository.save(person);
    }
}