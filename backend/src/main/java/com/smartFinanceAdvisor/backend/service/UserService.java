package com.smartFinanceAdvisor.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartFinanceAdvisor.backend.dto.UserRequest;
import com.smartFinanceAdvisor.backend.dto.UserResponse;
import com.smartFinanceAdvisor.backend.model.User;
import com.smartFinanceAdvisor.backend.repository.UserRepository;

//import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    
    // Spring Security interface for handling password hashing and verification
    private final PasswordEncoder passwordEncoder;
    
    
    @Autowired
    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder){
    	this.userRepository = userRepository;
    	this.passwordEncoder = passwordEncoder;
    }
    
    public UserResponse createUser(UserRequest request) {
        User user = new User(
                request.username(),
                request.email(),
                passwordEncoder.encode(request.password())
//                Hash (encode) passwords before storing them in the database.
//                This ensures the raw password is never stored in the database.
//                Hashing is one-way: can’t get the original password back.
        );
        
        userRepository.save(user);
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt());
    }
    
    public UserResponse getUser(Long id) {
        // Try to find the user by ID
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User u = optionalUser.get();
            return new UserResponse(u.getId(), u.getUsername(), u.getEmail(), u.getCreatedAt());
        } else {
            throw new RuntimeException("User not found");
        }
    }
    
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> responses = new ArrayList<UserResponse>();

        for (User u : users) {
            UserResponse response = new UserResponse(
                u.getId(),
                u.getUsername(),
                u.getEmail(),
                u.getCreatedAt()
            );
            responses.add(response);
        }

        return responses;
    }
}
