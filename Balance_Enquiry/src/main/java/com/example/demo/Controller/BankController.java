package com.example.demo.Controller;


import com.example.demo.Entity.Bank;
import com.example.demo.Service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping("/enquiry")
    public ResponseEntity<Object> checkBalance(@RequestParam Long id, @RequestParam String password) {
        Bank bank = bankService.findByIdAndPassword(id, password);

        if (bank == null) {
            return ResponseEntity.ok("No account found with this ID and password");
        } else {
            Long amount = bank.getAmount();
            return ResponseEntity.ok(amount);
        }
    }
}
