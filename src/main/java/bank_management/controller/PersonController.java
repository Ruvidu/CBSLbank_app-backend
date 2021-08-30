package bank_management.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank_management.exception.NotFoundException;
import bank_management.model.Person;
import bank_management.repository.PersonRepository;


@RestController
@RequestMapping("/api/person/")
@CrossOrigin
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/getpersons")
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	
	@PostMapping("/addperson")
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@GetMapping("/getperson/{id}")
	public ResponseEntity<Person> getPersonbyid(@PathVariable Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Person doesnt exist with id : "+id));
		return ResponseEntity.ok(person);
	}
	
	@PutMapping("/updateperson/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long id ,@RequestBody Person persondetails){
		Person person = personRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Person doesnt exist with id : "+id));
		person.setFirst_name(persondetails.getFirst_name());
		person.setLast_name(persondetails.getLast_name());
		person.setDob(persondetails.getDob());
		person.setPhone_number(persondetails.getPhone_number());
		person.setAddress(persondetails.getAddress());
		person.setGender(persondetails.getGender());
		
		Person updatedperson = personRepository.save(person);
		return ResponseEntity.ok(updatedperson);
	}
	
	@DeleteMapping("/deleteperson/{person_id}")
	public ResponseEntity<Map<String,Boolean>> deletePerson(@PathVariable Long person_id){
		Person person = personRepository.findById(person_id)
				.orElseThrow(()-> new NotFoundException("Person doesnt exist with id : "+person_id));
		personRepository.delete(person);
		Map<String , Boolean> response = new HashMap<>();
		response.put("Person Deleted successfully", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
