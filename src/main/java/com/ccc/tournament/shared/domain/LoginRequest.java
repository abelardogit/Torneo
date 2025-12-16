package com.ccc.tournament.shared.domain;

import lombok.Data;

@Data
public class LoginRequest {
    private String identifier;
    private String password;
}