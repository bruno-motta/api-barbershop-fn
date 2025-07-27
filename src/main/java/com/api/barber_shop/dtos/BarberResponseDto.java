package com.api.barber_shop.dtos;

import com.api.barber_shop.entity.enums.ActiveBarber;

import java.util.UUID;

public record BarberResponseDto(UUID id, String nameBarber, String specialtyBarber, ActiveBarber activeBarber) {
}
