package com.example.demo.Service;

import com.example.demo.Entity.Bank;
import com.example.demo.Repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

 @Autowired
 private BankRepository bankRepository;

 // Updated method to use id and password instead of username and password
 public Bank findByIdAndPassword(Long id, String password) {
     return bankRepository.findByIdAndPassword(id, password);
 }
}