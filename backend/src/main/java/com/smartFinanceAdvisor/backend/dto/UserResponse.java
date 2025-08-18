package com.smartFinanceAdvisor.backend.dto;

import java.time.LocalDateTime;

//DTOs enforce encapsulation — In this case for response controllers never expose DB entity directly.
public record UserResponse(
	Long id,
	String username,
	String email,
	LocalDateTime createdAt
) {}
