package com.everis.service;

import com.everis.entities.Person;
import com.everis.response.PersonResponse;
import java.util.List;

public interface PersonService {

  public List<Person> findAll();

  public PersonResponse findByDocument(String document) throws Exception;

  public Person update(Long id, Person person) throws Exception;

}
