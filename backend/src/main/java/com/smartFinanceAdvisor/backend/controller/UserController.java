package com.smartFinanceAdvisor.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartFinanceAdvisor.backend.dto.UserRequest;
import com.smartFinanceAdvisor.backend.dto.UserResponse;
import com.smartFinanceAdvisor.backend.service.UserService;

import jakarta.validation.Valid;

//import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
//@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@Autowired
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserRequest request) {
        return userService.createUser(request);
    }
    
    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
    
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }
}
