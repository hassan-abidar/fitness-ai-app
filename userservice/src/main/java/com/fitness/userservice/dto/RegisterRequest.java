package com.fitness.userservice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.jspecify.annotations.Nullable;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    @NotBlank(message = "The email is required")
    @Email(message = "Email format is not valid")
    private String email;
    @NotBlank(message = "The password is required")
    @Size(min = 6, message = "The password must be at least 6 characters")
    private String password;

}
