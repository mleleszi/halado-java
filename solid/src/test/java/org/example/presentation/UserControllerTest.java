package org.example.presentation;

import org.example.service.User;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;

    @Test
    void register_properInput() {
        // given
        String userName = "properUsername";
        Validator validatorOk = mock(Validator.class);
        when(validatorOk.isValid(anyString())).thenReturn(true);
        List<Validator> validatorList = new ArrayList<>();
        validatorList.add(validatorOk);

       // UserController userController

        // when
        boolean rv = userController.register(userName);

        // then
        assertTrue(rv);
        verify(userService, times(1)).save(ArgumentMatchers.<User>any());
    }

    @Test
    void register_InputWithSpace() {
        // given
        String userName = "wrong username";

        // when
        boolean rv = userController.register(userName);

        // then
        assertFalse(rv);
        verify(userService, times(0)).save(ArgumentMatchers.<User>any());
    }

    @Test
    void register_InputTooShort() {
        // given
        String userName = "wro";

        // when
        boolean rv = userController.register(userName);

        // then
        assertFalse(rv);
        verify(userService, times(0)).save(ArgumentMatchers.<User>any());
    }

    @Test
    void register_InputNull() {
        // given
        String userName = null;

        // when
        boolean rv = userController.register(userName);

        // then
        assertFalse(rv);
        verify(userService, times(0)).save(ArgumentMatchers.<User>any());
    }




}