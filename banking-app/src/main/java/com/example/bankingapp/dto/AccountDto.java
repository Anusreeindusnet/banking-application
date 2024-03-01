package com.example.bankingapp.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long id;
//    @NotEmpty(message = "Name is required")
//    @Size(min=2, max=30)
//    @Pattern(regexp = "^[A-Za-z]*$" , message = "invalid input")
//    @Column(name = "name", nullable = false)
    private String accountHolderName;
    private double balance;
}
