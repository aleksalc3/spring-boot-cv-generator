package com.aleksa.springbootcvgenerator.controller;

import com.aleksa.springbootcvgenerator.model.User;
import com.aleksa.springbootcvgenerator.service.IAuthenticationService;
import com.aleksa.springbootcvgenerator.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up")
    public ResponseEntity<User> signUp(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<User> signIn(@RequestBody User user){

        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
