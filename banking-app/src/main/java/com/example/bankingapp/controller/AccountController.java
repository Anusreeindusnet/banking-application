package com.example.bankingapp.controller;

import com.example.bankingapp.dto.AccountDto;
import com.example.bankingapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

  //Add Account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody @Valid AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

// Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto= accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }


    //Deposit REST API


    @PutMapping("/{id}/deposit")

    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
    return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String,Double> request){
        double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //Get all
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
       List<AccountDto>accounts= accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
// Delete Account
    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted succesfully");
}

}
