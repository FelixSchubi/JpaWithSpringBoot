package org.hameister.personmanager.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

    @Column(name =  "a61")
    String a61;

    @Column(name = "salary")
    Long salary;


    @Column(name = "birthday")
    LocalDate birthday;

    public Person() {
    }

    public Long getId() {
    return id;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }


    public String getA61() {
        return a61;
    }

    public void setA61(String a61) {
        this.a61 = a61;
    }

    public Long getSalary() {
    return salary;
    }

    public void setSalary(Long salary) {
    this.salary = salary;
    }

    public LocalDate getBirthday() {
    return birthday;
    }

    public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    }
}