package com.example.demo.Controller;

import com.example.demo.Service.DeleteAccountService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/accounts")
public class DeleteAccountController {

    @Autowired
    private DeleteAccountService deleteAccountService;

    @DeleteMapping("/delete")
    public String deleteAccount(@RequestBody JsonNode requestBody) {
        try {
            if (requestBody.get("id") == null || requestBody.get("password") == null) {
                return "ID or password missing.";
            }

            Long id = requestBody.get("id").asLong();
            String password = requestBody.get("password").asText();

            boolean deleted = deleteAccountService.deleteAccount(id, password);

            if (deleted) {
                return "Account deleted successfully.";
            } else {
                return "Invalid ID or password. Account not found.";
            }
        } catch (Exception e) {
            return "An error occurred while deleting the account.";
        }
    }
}