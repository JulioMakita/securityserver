package com.juliomakita.securityserver.com.juliomakita.securityserver.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @PreAuthorize("hasRole(@roles.ADMIN)")
    public boolean ensureAdmin() {
        
        return true;
    }
}
