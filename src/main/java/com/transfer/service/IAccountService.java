package com.transfer.service;

import com.transfer.dto.AccountDTO;
import com.transfer.dto.UpdateAccountDTO;

public interface IAccountService {

    AccountDTO createAccount(Long customerId, AccountDTO accountDTO);

    AccountDTO getAccountById(Long accountId);

    AccountDTO updateAccount(Long accountId, UpdateAccountDTO accountDTO);

    void deleteAccount(Long accountId);

    void deposit(Long accountId, Double amount);


}
