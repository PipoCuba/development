package com.alejandroTellez.developerTest.userAccounts;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="user_Account")

public class UserAccounts {

    @Id
    @Column(name="account_Id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long accountID;
    @Column(name = "owner")
    private Long owner;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "created_At")
    private LocalDateTime createdAt;

    public Long getAccountID() {
        return accountID;
    }

    public void setAccountID(Long accountID) {
        this.accountID = accountID;
    }




    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }



}
