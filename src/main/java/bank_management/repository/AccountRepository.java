package bank_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bank_management.model.Account;
import bank_management.model.Account_Key;



public interface AccountRepository extends JpaRepository<Account, Account_Key>  {

}
