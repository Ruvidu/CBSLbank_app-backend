package bank_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank_management.model.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
