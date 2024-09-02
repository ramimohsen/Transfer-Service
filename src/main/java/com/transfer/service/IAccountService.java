package com.transfer.service;

import com.transfer.dto.AccountDTO;
import com.transfer.dto.CreateAccountDTO;
import com.transfer.dto.UpdateAccountDTO;
import com.transfer.exception.custom.ResourceNotFoundException;

public interface IAccountService {

    AccountDTO createAccount(CreateAccountDTO accountDTO) throws ResourceNotFoundException;

    AccountDTO getAccountById(Long accountId) throws ResourceNotFoundException;

    AccountDTO updateAccount(Long accountId, UpdateAccountDTO accountDTO);

    void deleteAccount(Long accountId);

    void deposit(Long accountId, Double amount);


}
