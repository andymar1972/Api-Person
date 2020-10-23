package com.everis.service;

import com.everis.dao.PersonDao;
import com.everis.entities.Person;
import com.everis.response.PersonResponse;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  PersonDao personDao;

  @Override
  @Transactional
  public List<Person> findAll() {
    List<Person> listPersons = personDao.findAll();
    return listPersons;
  }

  @Override
  @Transactional
  public PersonResponse findByDocument(String document) throws Exception {

    // Obteniendo persona por documento.
    Optional<Person> optPerson = this.findAll().stream()
        .filter(person -> person.getDocument().equals(document))
        .findFirst();
    Person personDocument = optPerson.orElseThrow(Exception::new);

    // Lanzar exception si esta en lista negra
    if (personDocument.isBlackList()) {
      throw new Exception("Usuario en lista negra");
    }

    // Creando instancia de personResponse y agregando data.
    PersonResponse personResponse = new PersonResponse();
    personResponse.setId(personDocument.getId());
    personResponse.setDocument(personDocument.getDocument());
    personResponse.setFingerPrint(personDocument.isFingerPrint());
    personResponse.setBlackList(personDocument.isBlackList());
    
    // Si ya se consulto en reniec cambiar en BD false x true
    if (!personDocument.isFingerPrint()) {
      personDocument.setFingerPrint(true);
      this.update(personDocument.getId(), personDocument);
    }
    
    //Retornar personResponse
    return personResponse;
  }

  @Override
  @Transactional
  public Person update(Long id, Person person) throws Exception {
    try {
      Optional<Person> personOptional = personDao.findById(id);
      Person personUpdate = personOptional.get();
      personUpdate = personDao.saveAndFlush(personUpdate);
      return personUpdate;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }
}
