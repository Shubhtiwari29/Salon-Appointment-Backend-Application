package com.user.service;

import com.user.exception.UserException;
import com.user.modal.User;
import com.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createNewUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(@PathVariable Long id) throws Exception{
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new UserException("Could not find User");
    }

    @Override
    public User updateUser(@PathVariable Long id, @RequestBody User user)
            throws Exception{
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new Exception("User not found with Id : " +id);
        }
        User exsitingUser = optionalUser.get();
        exsitingUser.setFullName(user.getFullName());
        exsitingUser.setEmail(user.getEmail());
        exsitingUser.setPhone(user.getPhone());
        exsitingUser.setRole(user.getRole());
        return userRepository.save(exsitingUser);
    }

    @Override
    public String deleteUserById(@PathVariable Long id) throws Exception{
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new Exception("User doesn't exists with Id : " +id);
        }
        userRepository.deleteById(optionalUser.get().getId());
        return "User With ID : "+ id + " has been deleted";
    }
}
