package com.api.barber_shop.mappers;

import com.api.barber_shop.dtos.CustomerRequestDto;
import com.api.barber_shop.dtos.CustomerResponseDto;
import com.api.barber_shop.entity.CustomerEntity;

import java.time.LocalDateTime;

public class CustomerMapper {

    //Converter os dados convertidos na requisição HTTP, em um CustomerEntity
    public static CustomerEntity toEntity(CustomerRequestDto requestDto){
        return  new CustomerEntity(
                null,
                requestDto.nameCustomer(),
                requestDto.emailCustomer(),
                requestDto.telephoneCustomer(),
                LocalDateTime.now()

        );
    }

    //Converter a entidade CustomerEntity, em um CustomerResponseDto.
    //(Que será devolvido via Json na resposta da api)

    public static CustomerResponseDto toResponse(CustomerEntity entity){
        return  new CustomerResponseDto(
                entity.getId(),
                entity.getNameCustomer(),
                entity.getNameCustomer(),
                entity.getTelephoneCustomer(),
                entity.getDateTimeResgistration()
        );
    }
}
