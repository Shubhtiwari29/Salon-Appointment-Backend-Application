package com.user.service;

import com.user.modal.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    public User createNewUser(@RequestBody @Valid User user);

    public List<User> getAllUsers();

    public User getUserById(@PathVariable Long id) throws Exception;

    public User updateUser(@PathVariable Long id, @RequestBody User user)
            throws Exception;

    public String deleteUserById(@PathVariable Long id) throws Exception;

}
