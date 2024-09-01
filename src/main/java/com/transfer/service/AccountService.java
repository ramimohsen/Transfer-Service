package com.transfer.service;


import com.transfer.dto.AccountDTO;
import com.transfer.dto.UpdateAccountDTO;
import com.transfer.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountDTO createAccount(Long customerId, AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO getAccountById(Long accountId) {
        return null;
    }

    @Override
    public AccountDTO updateAccount(Long accountId, UpdateAccountDTO accountDTO) {
        return null;
    }

    @Override
    public void deleteAccount(Long accountId) {

    }

    @Override
    public void deposit(Long accountId, Double amount) {

    }
}
