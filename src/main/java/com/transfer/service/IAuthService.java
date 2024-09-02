package com.transfer.service;

import com.transfer.dto.RegisterCustomerRequest;
import com.transfer.dto.RegisterCustomerResponse;
import com.transfer.exception.custom.CustomerAlreadyExistException;

public interface IAuthService {

    /**
     * Register a new customer
     *
     * @param customer the customer to be registered
     * @return the registered customer
     * @throws CustomerAlreadyExistException if the customer already exists
     */
    RegisterCustomerResponse register(RegisterCustomerRequest customer) throws CustomerAlreadyExistException;

}
