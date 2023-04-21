package com.tourgenius.accountservice.service;

import com.tourgenius.accountservice.dto.AccountDto;
import com.tourgenius.accountservice.exception.AccountNotFoundException;
import com.tourgenius.accountservice.model.Account;
import com.tourgenius.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public boolean createAccount(@NotNull AccountDto accountDto) {
        String accountId = encrypt(accountDto.getEmail());
        if(accountRepository.findById(accountId).isEmpty()){
            Account account = new Account();
            account.setAccountId(accountId);
            account.setPassword(encrypt(accountDto.getPassword()));
            account.setRole(accountDto.getRole());
            accountRepository.save(account);
            return true;
        }
        return false;
    }

    @Override
    public Account changePassword(String email, String newPassword) {
        Account currentAccount = accountRepository.findById(encrypt(email)).orElseThrow(() ->
                new AccountNotFoundException("Email", email));
        currentAccount.setPassword(encrypt(newPassword));
        return accountRepository.save(currentAccount);
    }

    @Override
    public boolean deleteAccount(String email) {
        String accountId = encrypt(email);
        if(accountRepository.findById(accountId).isEmpty()){
            return false;
        }
        accountRepository.deleteById(accountId);
        return true;
    }

    @Override
    public boolean authenticateAccount(String email, String password) {
        return accountRepository.findAccountByAccountIdAndPassword(encrypt(email), encrypt(password)).isPresent();
    }

    @Override
    public String encrypt(String plainText) {
        return new DigestUtils("SHA3-256").digestAsHex(plainText);
    }
}
