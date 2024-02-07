package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.dto.v1.PersonDTO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<Person> findAll(){
		logger.info("finding all people");
		
		return repository.findAll();
	}
	
	public PersonDTO findById(Long id) {
		Person person = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		return modelMapper.map(person, PersonDTO.class);
	}
	
	
	public PersonDTO create(PersonDTO person) {
		logger.info("create one person");
		Person mappedEntity = modelMapper.map(person, Person.class);
		repository.save(mappedEntity);
		return person;
	}
	
	public PersonDTO update(Long id, PersonDTO person) {
		logger.info("update one person");
		
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		BeanUtils.copyProperties(person, entity);
		entity = repository.save(entity);
		
		return modelMapper.map(entity, PersonDTO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
		
		repository.delete(entity);
	}
}
