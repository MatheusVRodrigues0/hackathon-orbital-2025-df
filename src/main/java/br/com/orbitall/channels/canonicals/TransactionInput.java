package br.com.orbitall.channels.canonicals;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionInput(
        //@NotBlank(message = "Full name cannot be null or empty")
        //@Size(min = 1, max = 255, message = "Full name must be between 1 and 255 characters")
        UUID customerId,

        //@NotBlank(message = "Email cannot be null or empty")
        //@Size(min = 1, max = 100, message = "Email must be between 1 and 100 characters")
        BigDecimal amount,

        //@NotBlank(message = "Phone cannot be null or empty")
        String cardType
) {
}
