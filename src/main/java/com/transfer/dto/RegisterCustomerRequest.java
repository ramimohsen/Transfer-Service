package com.transfer.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RegisterCustomerRequest {

    private String name;

    private String email;

    private String password;
}
