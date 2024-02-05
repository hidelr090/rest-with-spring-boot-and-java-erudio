package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll(){
		logger.info("finding all people");
		List<Person> persons = new ArrayList<Person>();
		
		for(int i = 0; i < 10; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}
	
	public Person findById(String id) {
		logger.info("finding one person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setAddress("Rua Alfeneira");
		person.setFirstName("Pedrinha");
		person.setLastName("Moraes");
		person.setGender("Fazendo um som");
		return person;
	}
	
	private Person mockPerson(int i) {
		logger.info("finding one person");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setAddress("Rua Alfeneira");
		person.setFirstName("Pedrinha" + i);
		person.setLastName("Moraes" + i);
		person.setGender("Fazendo um som" + i);
		return person;
	}
	
	public Person create(Person person) {
		logger.info("create one person");
		return person;
	}
	
	public Person update(String id, Person person) {
		logger.info("update one person");
		return person;
	}
	
	public void delete(String id) {
		logger.info("delete one person");
	}
}
