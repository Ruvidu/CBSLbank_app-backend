package bank_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank_management.model.Account;
import bank_management.repository.AccountRepository;


@RestController
@RequestMapping("/api/account/")
@CrossOrigin
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/getaccounts")
	public List<Account> getAllAccounts(){
		return accountRepository.findAll();
	}
	

}
