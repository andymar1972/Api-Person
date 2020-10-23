package com.everis.apis;

import com.everis.entities.Person;
import com.everis.response.PersonResponse;
import com.everis.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonApi {

  @Autowired
  PersonService personService;

  @GetMapping("/core/persons/")
  public List<Person> list() throws Exception {
    return personService.findAll();
  }

  @GetMapping("/core/persons/documentNumber/{document}")
  public PersonResponse findByDocument(@PathVariable String document) throws Exception {
    return personService.findByDocument(document);
  }
  
  

}
