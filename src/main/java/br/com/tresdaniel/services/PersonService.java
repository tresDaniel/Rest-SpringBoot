package br.com.tresdaniel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tresdaniel.adapter.DozerAdapter;
import br.com.tresdaniel.data.models.Person;
import br.com.tresdaniel.data.vo.v1.PersonVO;
import br.com.tresdaniel.exception.ResourceNotFoundException;
import br.com.tresdaniel.request.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerAdapter.parseObject(person, Person.class);
		return DozerAdapter.parseObject(repository.save(entity), PersonVO.class);
	}

	public List<PersonVO> findAll() {
		return DozerAdapter.parseListObject(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerAdapter.parseObject(entity, PersonVO.class);
		
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return DozerAdapter.parseObject(repository.save(entity), PersonVO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
}
