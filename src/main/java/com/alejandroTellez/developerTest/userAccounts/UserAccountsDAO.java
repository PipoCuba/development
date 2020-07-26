package com.alejandroTellez.developerTest.userAccounts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountsDAO extends JpaRepository<UserAccounts,Long> {
}
