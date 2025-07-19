package com.api.barber_shop.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CustomerRequestDto(

        @NotBlank(message = "O nome não pode ficar em Branco!")
        String nameCustomer,

        @NotBlank(message = "O campo e-mail não pode ficar em branco!")
        @Email
        String emailCustomer,

        @NotBlank(message = "O campo telefone não pode ficar em branco!")
        @Size(max = 15, message = ("Tamanho maior que o suportado, coloque corretamente!"))
        String telephoneCustomer
) {
}
