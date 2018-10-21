package com.juliomakita.securityserver.com.juliomakita.securityserver.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @PreAuthorize("hasRole(@roles.USER)")
    public boolean ensureUser() {
        return true;
    }
}
