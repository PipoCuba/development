package com.alejandroTellez.developerTest.moneyTransfer;

import com.alejandroTellez.developerTest.userAccounts.UserAccounts;
import com.alejandroTellez.developerTest.userAccounts.UserAccountsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/transactions/")
@RestController
public class MoneyTransferController {

    @Autowired
    private MoneyTransferDAO moneyTransferDAO;

    @Autowired
    private UserAccountsDAO userAccountsDAO;
    @Autowired
    private UserAccountsDAO userAccountsDAO1;

    @PostMapping("/newTransfer")
    public ResponseEntity<MoneyTransfer> newTransfer(@RequestParam("fromAccount") Long fromAccount,
                                                      @RequestParam("toAccount") Long toAccount,
                                                      @RequestParam("amount") Double amount){
            MoneyTransfer moneyTransfer=new MoneyTransfer();
        Optional<UserAccounts> userAccountsFrom=userAccountsDAO.findById(fromAccount);
        Optional<UserAccounts> userAccountsTo=userAccountsDAO1.findById(toAccount);
        if (userAccountsFrom.isPresent() && userAccountsTo.isPresent()){
            if(userAccountsFrom.get().getBalance() - amount > -500) {
                userAccountsTo.get().setBalance(userAccountsTo.get().getBalance() + amount);
                userAccountsFrom.get().setBalance(userAccountsFrom.get().getBalance() - amount);
                moneyTransfer.setSentAt(LocalDateTime.now());
                moneyTransfer.setFromAccount(fromAccount);
                moneyTransfer.setToAccount(toAccount);
                moneyTransfer.setAmmount(amount);
                moneyTransferDAO.save(moneyTransfer);
                return ResponseEntity.ok(moneyTransfer);
            }
            else {
                 return ResponseEntity.noContent().build();            }
            }else {
            return ResponseEntity.noContent().build();
        }


    }

    @GetMapping("listAllTransactions/{accountId}")
    public ResponseEntity<List<MoneyTransfer>> getAllSentTTransactions( @PathVariable("accountId") Long accountId){
        List<MoneyTransfer> moneyTransferList=moneyTransferDAO.findAll();
        List<MoneyTransfer> moneyTransactionsList= new ArrayList<>();
        for (MoneyTransfer moneyTransfer: moneyTransferList){
            if (moneyTransfer.getFromAccount()==accountId || moneyTransfer.getToAccount()==accountId )
                moneyTransactionsList.add(moneyTransfer);
        }
        return ResponseEntity.ok(moneyTransactionsList);
    }

    @GetMapping("listAllSent/{sentFromId}")
    public ResponseEntity<List<MoneyTransfer>> getAllSentTransfers( @PathVariable("sentFromId") Long sentFrom){
        List<MoneyTransfer> moneyTransferList=moneyTransferDAO.findAll();
        List<MoneyTransfer> moneyTransferSentList= new ArrayList<>();
      for (MoneyTransfer moneyTransfer: moneyTransferList){
          if (moneyTransfer.getFromAccount()==sentFrom)
        moneyTransferSentList.add(moneyTransfer);
      }
        return ResponseEntity.ok(moneyTransferSentList);
    }

    @GetMapping("listAllReceived/{receivedFromId}")
    public ResponseEntity<List<MoneyTransfer>> getAllReceivedTransfers( @PathVariable("receivedFromId") Long receivedFrom){
        List<MoneyTransfer> moneyTransferList=moneyTransferDAO.findAll();
        List<MoneyTransfer> moneyTransferReceivedList= new ArrayList<>();
        for (MoneyTransfer moneyTransfer: moneyTransferList){
            if (moneyTransfer.getToAccount()==receivedFrom)
                moneyTransferReceivedList.add(moneyTransfer);
        }
        return ResponseEntity.ok(moneyTransferReceivedList);
    }

}
