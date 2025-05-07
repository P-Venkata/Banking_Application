package com.example.demo.FeignClient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "balance-enquiry")
public interface BalanceEnquiryClient {

    @GetMapping("/bank/enquiry")
    Long getBalance(@RequestParam("id") Long id, @RequestParam("password") String password);
}