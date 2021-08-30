package bank_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank_management.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
