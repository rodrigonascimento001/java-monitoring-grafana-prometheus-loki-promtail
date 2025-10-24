package com.br.rmm.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ErrorResponse (
        String error,
        String message,
        LocalDateTime timestamp
        ) implements Serializable{ }
