package com.smartFinanceAdvisor.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


//A record is a special type of class introduced in Java 14 (preview) / Java 16 (stable).
//It’s meant for data carriers — immutable objects that just hold values, like DTOs. |
//https://www.baeldung.com/java-record-keyword
//Useful for:
//	Passing immutable data between objects
//	reducing boilerplate code
//	automatically update our classes when we add a new field
// Seems similar to lombok

//DTOs enforce encapsulation — In this case for request we fil;ter what can be sent to the DB
public record UserRequest(
		@NotBlank @Size(min = 3, max = 50) String username,
	    @NotBlank @Email String email,
	    @NotBlank @Size(min = 6) String password
) {}
