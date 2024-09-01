package com.transfer.service;

import com.transfer.dto.RegisterCustomerRequest;
import com.transfer.dto.RegisterCustomerResponse;
import com.transfer.dto.enums.AccountCurrency;
import com.transfer.dto.enums.AccountType;
import com.transfer.entity.Account;
import com.transfer.entity.Customer;
import com.transfer.repository.AccountRepository;
import com.transfer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final CustomerRepository customerRepository;

    private final AccountRepository accountRepository;

    @Transactional
    public RegisterCustomerResponse register(RegisterCustomerRequest customerRequest) {

        // Create the customer entity
        Customer customer = Customer.builder()
                .email(customerRequest.getEmail())
                .password(customerRequest.getPassword())
                .name(customerRequest.getName())
                .build();

        // Create and link the accounts to the customer
        Account account = Account.builder()
                .balance(0.0)
                .accountType(AccountType.SAVINGS)
                .accountDescription("Savings Account")
                .accountName("Savings Account")
                .currency(AccountCurrency.EGP)
                .accountNumber(new SecureRandom().nextInt(1000000000) + "")
                .customer(customer) // Link the account to the customer
                .build();

        // Add the account to the customer's set of accounts
        customer.getAccounts().add(account);

        // Save the customer and cascade persist the accounts
        Customer savedCustomer = customerRepository.save(customer);

        // Return the response
        return savedCustomer.toResponse();
    }


    public List<RegisterCustomerResponse> getUsers() {
        return this.customerRepository.findAll().stream().map(Customer::toResponse).toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.customerRepository.existsByEmail(email);
    }
}
