package com.example.demo.Repository;



import com.example.demo.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
 Bank findByIdAndPassword(Long id, String password);
}