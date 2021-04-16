package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class PersonController {



    @Autowired
    private final PersonRepository personRepository;

    PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
       }

    @PostMapping("/people")
    public Person createPerson(Person p){return personRepository.save(p);}

    @GetMapping("/people/{id}")
    public Person getPerson(Integer id){

        return personRepository.findOne(id);}

    @GetMapping("/people")
    public List<Person> getPersonList() {
        List<Person>people=new ArrayList<Person>();
        for (Person p : personRepository.findAll()) {
            people.add(p);
        }
        return people;
    }
        @PutMapping("/people/{id}")
        public Person updatePerson (Person p, Integer id){
            Person holder = personRepository.findOne(p.getId());
            holder.setFirstname(p.firstname);
            holder.setLastname(p.lastname);
            return personRepository.save(holder);
        }

        @DeleteMapping("/people/{id}")
        public void deletePerson ( Integer id){
            personRepository.delete(id);
        }

}

