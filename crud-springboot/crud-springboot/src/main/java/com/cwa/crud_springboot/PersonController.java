package com.cwa.crud_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//necessaire pour que la clase soit reconnu comme controller et donc gerer comme tel
@RequestMapping("/api/persons")
public class PersonController {
    final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }
    /*ResponseEntity est une classe qui renvoie une valeur duale celle de Person ou non, et le statut
    * de la requête (echoué, réussi, notfound, ok etc...*/

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person personCreated = personRepository.save(person);
        /*PersonRepository.save() permet elegament de mettre la BD a jour et retourne
        l'objet à sauvegarer si tout s'est bien passé*/
        return new ResponseEntity<>(personCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id){
        Optional<Person> person = personRepository.findById(id);
    /*ici person est une table contenant les persons aynant un ID =  id*/
        return person.isPresent() ? new ResponseEntity<>(person.get(), HttpStatus.OK) : new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personDetails){
        Optional<Person> person = personRepository.findById(id);
        /*ma méthode .find...() retourne un Optional qui est un objet ayant la valeur demandé
        * ou non.*/
        /*ici person est une table contenant les persons aynant un ID =  id*/
        /*pour manipuler cette personne on devra donc la recuperer avec un get()*/
        if (person.isPresent()){
            Person existingPerson = person.get();
            existingPerson.setCity(personDetails.getCity());
            existingPerson.setPhoneNumber(personDetails.getPhoneNumber());

            Person updatedPerson = personRepository.save(existingPerson);
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){
        Optional<Person> person = personRepository.findById(id);

        if (person.isPresent()){
            personRepository.delete(person.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
