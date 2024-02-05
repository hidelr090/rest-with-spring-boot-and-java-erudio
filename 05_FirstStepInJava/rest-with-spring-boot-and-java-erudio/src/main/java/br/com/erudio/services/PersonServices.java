package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll(){
		logger.info("finding all people");
		
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		logger.info("finding one person");
		Person person = new Person();
		person.setAddress("Rua Alfeneira");
		person.setFirstName("Pedrinha");
		person.setLastName("Moraes");
		person.setGender("Fazendo um som");
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
	}
	
	
	public Person create(Person person) {
		logger.info("create one person");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("update one person");
		
		Person entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		repository.delete(entity);
	}
}
