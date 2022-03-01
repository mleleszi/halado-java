package org.example.presentation;

import org.example.service.User;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final UserService userService;
    private final List<Validator> validatorList;

    public UserController(UserService userService, List<Validator> validatorList) {
        this.userService = userService;
        this.validatorList = validatorList;
    }

    public boolean register(String name) {
        if (isValid(name)) {
            userService.save(new User());
            return true;
        } else {
            return false;
        }
    }


    private boolean isValid(String name) {
        for (Validator validator : validatorList) {
            if (!validator.isValid(name)) {
                return false;
            }
        }
        return true;
    }
}
