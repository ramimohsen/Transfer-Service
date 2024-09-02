package com.transfer.controller;

import com.transfer.dto.AccountDTO;
import com.transfer.dto.CreateAccountDTO;
import com.transfer.exception.custom.ResourceNotFoundException;
import com.transfer.service.IAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
@Validated
public class AccountController {

    private final IAccountService accountService;

    @PostMapping
    public AccountDTO createAccount(@Valid @RequestBody CreateAccountDTO accountDTO) throws ResourceNotFoundException {
        return this.accountService.createAccount(accountDTO);
    }

    @GetMapping("/{accountId}")
    public AccountDTO getAccountById(@PathVariable Long accountId) throws ResourceNotFoundException {
        return this.accountService.getAccountById(accountId);
    }
}
