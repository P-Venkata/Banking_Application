package com.example.demo.Controlller;

import com.example.demo.Entity.Bank;
import com.example.demo.FeignClient.BalanceEnquiryClient;
import com.example.demo.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/deposit")
public class DepositController {

    @Autowired
    private BankService bankService;

    @Autowired
    private BalanceEnquiryClient balanceEnquiryClient;

    @PostMapping
    public ResponseEntity<String> depositAmount(@RequestParam Long id,
                                                @RequestParam String password,
                                                @RequestParam long amount) {

        // Step 1: Authenticate
        Bank bank = bankService.findByIdAndPassword(id, password);
        if (bank == null) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }

        // Step 2: Validate deposit
        if (amount <= 0) {
            return ResponseEntity.badRequest().body("Deposit amount must be greater than 0");
        }

        // Step 3: Get current balance from BalanceEnquiry service
        long currentBalance = balanceEnquiryClient.getBalance(id, password);

        // Step 4: Calculate new balance
        long newBalance = currentBalance + amount;

        // Step 5: Update balance in DB
        bank.setAmount(newBalance);
        bankService.save(bank);

        return ResponseEntity.ok("Deposit successful. New balance: " + newBalance);
    }
}