package org.ppke.itk.registrationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.ppke.itk.registrationsystem.domain.BankAccount;
import org.ppke.itk.registrationsystem.repository.BankAccountRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;

    @Secured("ROLE_ADMIN")
    @GetMapping()
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Secured({"ROLE_ADMIN", "ROLE_VIEWER"})
    @GetMapping(value = "/{id}")
    public BankAccount getBankAccountById(@PathVariable long id) {
        return bankAccountRepository.findById(id).get();
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public void addNewBankAccount(@RequestBody BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/{id}")
    public void updateBankAccountById(@PathVariable long id,
                                      @RequestBody BankAccount bankAccount) {
        if (bankAccountRepository.findById(id).isPresent()) {
            bankAccount.setId(id);
            bankAccountRepository.save(bankAccount);
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/{id}")
    public void deleteBankAccountById(@PathVariable long id) {
        bankAccountRepository.deleteById(id);
    }
}
