package dev.godraadam.untold.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.godraadam.untold.exception.ResourceConflictException;
import dev.godraadam.untold.exception.ResourceNotFoundException;
import dev.godraadam.untold.exception.UnauthorizedException;
import dev.godraadam.untold.exception.UnprocessableEntityException;
import dev.godraadam.untold.model.Role;
import dev.godraadam.untold.model.User;
import dev.godraadam.untold.repo.UserRepo;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ValidationService validator;

    private User registerUser(User user, Role role) throws ResourceConflictException, UnprocessableEntityException {
        // validate username and password
        if (!validator.validateUsername(user.getUsername()))
            throw new UnprocessableEntityException();
        if (!validator.validatePassword(user.getPassword()))
            throw new UnprocessableEntityException();

        // check if username is available
        userRepo.findByUsername(user.getUsername()).ifPresent(u -> {throw new ResourceConflictException();});

        // encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);

        // persist user
        return userRepo.save(user);
    }

    public User registerCashier(User user) throws ResourceConflictException, UnprocessableEntityException {
        return registerUser(user, Role.CASHIER);
    }

    public User registerAdmin(User user) throws ResourceConflictException, UnprocessableEntityException {
        return registerUser(user, Role.ADMIN);
    }

    public List<User> getCashiers() {
        return userRepo.findByRole(Role.CASHIER);
    }

    public User getUserByUsername(String username) throws ResourceNotFoundException {
        return userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException());

    }

    public void deleteUser(String username) throws ResourceNotFoundException {
        userRepo.delete(userRepo.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException()));
    }

    public User updateUser(User user) throws ResourceConflictException {
        //check if username is available
        userRepo.findByUsername(user.getUsername()).ifPresent(u ->{ if ((u.getId().equals(user.getId()))) throw new ResourceConflictException();});
  
        return userRepo.save(user);
    }

    public User login(User user) throws UnauthorizedException, ResourceNotFoundException {

        User userFromRepo = userRepo.findByUsername(user.getUsername()).orElseThrow(() -> new ResourceNotFoundException());
        if(!passwordEncoder.matches(user.getPassword(), userFromRepo.getPassword())) throw new UnauthorizedException();
        return userFromRepo;
    }

}
