package com.transfer.service;

import com.transfer.dto.RegisterCustomerRequest;
import com.transfer.dto.RegisterCustomerResponse;
import com.transfer.exception.custom.CustomerAlreadyExistException;

import java.util.List;

public interface IAuthService {

    RegisterCustomerResponse register(RegisterCustomerRequest customer) throws CustomerAlreadyExistException;

    List<RegisterCustomerResponse> getUsers();

    boolean existsByEmail(String email);
}
