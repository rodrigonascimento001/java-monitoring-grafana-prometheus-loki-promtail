package com.br.rmm.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record Customer(
        @NotBlank(message = "O campo name é obrigatório")
        String name,
        @NotNull(message = "O campo age é obrigatório")
        int age) implements Serializable { }
