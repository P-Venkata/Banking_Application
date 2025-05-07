package com.example.demo.Controller;

import com.example.demo.Entity.Bank;
import com.example.demo.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/accounts")
public class Create_Account {

    @Autowired
    private BankService bankService;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(@RequestBody Bank bank) {
        String result = bankService.createAccount(bank);
        return ResponseEntity.ok(result);
    }
}