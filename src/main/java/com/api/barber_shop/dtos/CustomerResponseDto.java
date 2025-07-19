package com.api.barber_shop.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CustomerResponseDto(
        UUID idCustomer,
        String nameCustomer,
        String emailCustomer,
        String telephoneCustomer,
        LocalDateTime dateTimeResgistration
) {
}
