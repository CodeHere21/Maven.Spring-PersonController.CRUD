package io.zipcoder.crudapp;
//
//import org.springframework.data.repository.CrudRepository;
//
//public interface PersonRepository extends CrudRepository<Person, Long> {
//}


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Map;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findById(Long id);

}