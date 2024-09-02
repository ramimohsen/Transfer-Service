package com.transfer.controller;

import com.transfer.dto.RegisterCustomerRequest;
import com.transfer.dto.RegisterCustomerResponse;
import com.transfer.exception.custom.CustomerAlreadyExistException;
import com.transfer.service.IAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/register")
    public RegisterCustomerResponse register(@RequestBody @Valid RegisterCustomerRequest customer) throws CustomerAlreadyExistException {
        return this.authService.register(customer);
    }

    @GetMapping("/users")
    public List<RegisterCustomerResponse> getUsers() {
        return authService.getUsers();
    }

    @GetMapping("/{email}")
    public boolean existsByEmail(@PathVariable String email) {
        return authService.existsByEmail(email);
    }

}
