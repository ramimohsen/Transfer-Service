package com.transfer.controller;

import com.transfer.dto.RegisterCustomerRequest;
import com.transfer.dto.RegisterCustomerResponse;
import com.transfer.exception.custom.CustomerAlreadyExistException;
import com.transfer.exception.response.ErrorDetails;
import com.transfer.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Customer Auth Controller", description = "Customer Auth controller")
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Register new Customer")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = RegisterCustomerResponse.class), mediaType = "application/json")})
    @ApiResponse(responseCode = "400", content = {@Content(schema = @Schema(implementation = ErrorDetails.class), mediaType = "application/json")})
    public RegisterCustomerResponse register(@RequestBody @Valid RegisterCustomerRequest customer) throws CustomerAlreadyExistException {
        return this.authService.register(customer);
    }

}
