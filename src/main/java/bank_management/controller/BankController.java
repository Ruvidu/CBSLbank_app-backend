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
import bank_management.model.Bank;
import bank_management.repository.BankRepository;

@RestController
@RequestMapping("/api/bank/")
@CrossOrigin
public class BankController {
	@Autowired
	private BankRepository bankRepository;
	
	@GetMapping("/getbanks")
	public List<Bank> getAllBanks(){
		return bankRepository.findAll();
	}
	
	@PostMapping("/addbank")
	public Bank createBank(@RequestBody Bank bank) {
		return bankRepository.save(bank);
	}
	
	@GetMapping("/getbank/{id}")
	public ResponseEntity<Bank> getBankbyid(@PathVariable Long id) {
		Bank bank = bankRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Bank doesnt exist with id : "+id));
		return ResponseEntity.ok(bank);
	}
	
	@PutMapping("/updatebank/{id}")
	public ResponseEntity<Bank> updateBank(@PathVariable Long id ,@RequestBody Bank bankdetails){
		Bank bank = bankRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Bank doesnt exist with id : "+id));
		bank.setName(bankdetails.getName());
		
		Bank updatedbank = bankRepository.save(bank);
		return ResponseEntity.ok(updatedbank);
	}
	
	@DeleteMapping("/deletebank/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteBank(@PathVariable Long id){
		Bank bank = bankRepository.findById(id)
				.orElseThrow(()-> new NotFoundException("Bank doesnt exist with id : "+id));
		bankRepository.delete(bank);
		Map<String , Boolean> response = new HashMap<>();
		response.put("Bank Deleted successfully", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
