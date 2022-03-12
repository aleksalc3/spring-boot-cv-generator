package com.aleksa.springbootcvgenerator.service;

import com.aleksa.springbootcvgenerator.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
