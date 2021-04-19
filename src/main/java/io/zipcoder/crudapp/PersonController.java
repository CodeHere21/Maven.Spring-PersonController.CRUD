package io.zipcoder.crudapp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//@RequestMapping("/people")
//@RestController
//public class PersonController {
//
//
//
//
//    private final PersonRepository personRepository;
//
//    @Autowired
//    PersonController(PersonRepository personRepository){
//        this.personRepository = personRepository;
//       }
//
//    @PostMapping("/people")
//    public Person createPerson(Person p){return personRepository.save(p);}
//
//    @GetMapping("/people/{id}")
//    public Person getPerson(Long id){
//
//        return personRepository.findOne(id);}
//
//    @GetMapping(value="/people")
//    public List<Person> getPersonList() {
//        List<Person> people = new ArrayList<Person>();
//        for (Person p : personRepository.findAll()) {
//            people.add(p);
//        }
//        return people;
//    }
//        @PutMapping("/people/{id}")
//        public Person updatePerson (Person p, Long id){
//            Person holder = personRepository.findOne(id);
//            holder.setFirstname(p.firstname);
//            holder.setLastname(p.lastname);
//            return personRepository.save(holder);
//        }
//
//        @DeleteMapping("/people/{id}")
//        public void deletePerson ( Long id){
//            personRepository.delete(id);
//        }
//
//}
//




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonController {

    @Autowired
    public PersonRepository personRepository;


    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);
    }

    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person p, @PathVariable int id) {
        if (p.getId() != null) {
            return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
        } else {
            return createPerson(p);
        }
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity DeletePerson(@PathVariable Long id){
        personRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}