package com.alejandroTellez.developerTest.userAccounts;

import com.alejandroTellez.developerTest.moneyTransfer.MoneyTransferDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/accounts")
public class UserAccountsController {
    @Autowired
    private UserAccountsDAO userAccountsDAO;

    @GetMapping("{accountId}")
    public ResponseEntity<UserAccounts> getAccountBalance(@PathVariable("accountId") Long accountId){
        Optional<UserAccounts> userAccounts= userAccountsDAO.findById(accountId);
        if (userAccounts.isPresent()) {
            return ResponseEntity.ok(userAccounts.get());
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }


    @PostMapping("/create")
    public ResponseEntity<UserAccounts> createAccount(@RequestParam("owner") Long owner,
                                                          @RequestParam("balance") Double balance){
       UserAccounts userAccounts= new UserAccounts();
       userAccounts.setOwner(owner);
       userAccounts.setBalance(balance);
        userAccounts.setCreatedAt(LocalDateTime.now());
       userAccountsDAO.save(userAccounts);
        return ResponseEntity.ok(userAccounts);
    }
}
