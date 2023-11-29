package org.ppke.itk.registrationsystem.repository;

import org.ppke.itk.registrationsystem.domain.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {}
