package com.juliomakita.securityserver.com.juliomakita.securityserver.controller;

import com.juliomakita.securityserver.com.juliomakita.securityserver.service.AdminService;
import com.juliomakita.securityserver.com.juliomakita.securityserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.security.Principal;

@RestController
public class HomeController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/")
    public ResponseEntity<?> defaultmethod() {
        return new ResponseEntity<>("You have access!", HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/home")
    public ResponseEntity<?> home (final Principal principal, final Authentication authentication, final HttpServletRequest request){

        try{

            Principal p = request.getUserPrincipal();

            return new ResponseEntity<>("User: " + p.getName(), HttpStatus.ACCEPTED );
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST );
        }

    }

    @GetMapping(path = "/admin")
    public ResponseEntity<?> admin(){

        if(adminService.ensureAdmin()){
            return new ResponseEntity<>("You are an admin", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("You are not an admin", HttpStatus.ACCEPTED);
        }
    }

    @GetMapping(path = "/user")
    public ResponseEntity<?> user(final Principal principal){

        if(userService.ensureUser()){
            return new ResponseEntity<>("You are an USER", HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("You are not an USER", HttpStatus.ACCEPTED);
        }
    }
}
