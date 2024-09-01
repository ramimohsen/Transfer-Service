package com.transfer.service;

import com.transfer.dto.RegisterCustomerRequest;
import com.transfer.dto.RegisterCustomerResponse;

import java.util.List;

public interface IAuthService {

    RegisterCustomerResponse register(RegisterCustomerRequest customer);

    List<RegisterCustomerResponse> getUsers();

    boolean existsByEmail(String email);
}
