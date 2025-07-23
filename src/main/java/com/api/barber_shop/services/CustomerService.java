package com.api.barber_shop.services;

import com.api.barber_shop.dtos.CustomerRequestDto;
import com.api.barber_shop.dtos.CustomerResponseDto;
import com.api.barber_shop.entity.CustomerEntity;
import com.api.barber_shop.mappers.CustomerMapper;
import com.api.barber_shop.repositorys.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerService {

     private final CustomerRepository customerRepository;

     //TODO: EXCEÇÕES ***

     public CustomerResponseDto savedCustomer(CustomerRequestDto customerRequest){
         if(customerRepository.findByEmailCustomer(customerRequest.emailCustomer()).isPresent()){
             throw new RuntimeException("E-mail já cadastro, tente outro");
         }
         if(customerRepository.findByTelephoneCustomer(customerRequest.telephoneCustomer()).isPresent()){
             throw new RuntimeException("Telefone já cadastrado, tente outro");
         }

         CustomerEntity entity = CustomerMapper.toEntity(customerRequest);
         entity.setDateTimeResgistration(LocalDateTime.now());
         CustomerEntity savedCustomerEntity = customerRepository.save(entity);

         return CustomerMapper.toResponse(savedCustomerEntity);

     }

     public CustomerResponseDto getCustomerEmail(String email){
         CustomerEntity getEmail = customerRepository.findByEmailCustomer(email).orElseThrow(
                 () -> new RuntimeException("E-mail não encontrado.")
         );
         return CustomerMapper.toResponse(getEmail);
     }

     public CustomerResponseDto getCustomerTelephone(String telephone){
         CustomerEntity getTelephone = customerRepository.findByTelephoneCustomer(telephone).orElseThrow(
                 () -> new RuntimeException("Telefone não encontrado.")
         );
         return CustomerMapper.toResponse(getTelephone);
     }

    public void deleteByEmail(String emailDelete){
        CustomerEntity deleteEntityEmail = customerRepository.findByEmailCustomer(emailDelete).orElseThrow(
                () -> new RuntimeException("Cliente com esse e-mail não existe!")
        );
        customerRepository.deleteByEmailCustomer(emailDelete);
    }

    public void deleteById(UUID idCustomer){
        CustomerEntity deleteEntityId = customerRepository.findById(idCustomer).orElseThrow(
                () -> new RuntimeException("ID não encontrado")
        );
        customerRepository.deleteById(idCustomer);
    }

    public CustomerResponseDto updateCustomer(UUID id, CustomerRequestDto requestDto){
         CustomerEntity entityToUpdate = customerRepository.findById(id).orElseThrow(
                 () -> new RuntimeException("Id não encontrado")
         );

         Optional<CustomerEntity> existingEmail = customerRepository.findByEmailCustomer(requestDto.emailCustomer());
         if(existingEmail.isPresent() && !existingEmail.get().getId().equals(id)){
             throw new RuntimeException("E-mail já cadastrado, tente novamente");
         }

         Optional<CustomerEntity> existingTelephone = customerRepository.findByTelephoneCustomer(requestDto.telephoneCustomer());
        if (existingTelephone.isPresent() && !existingTelephone.get().getId().equals(id));

        entityToUpdate.setNameCustomer(requestDto.nameCustomer());
        entityToUpdate.setEmailCustomer(requestDto.emailCustomer());
        entityToUpdate.setTelephoneCustomer(requestDto.telephoneCustomer());

        CustomerEntity updated = customerRepository.save(entityToUpdate);
        return CustomerMapper.toResponse(updated);



    }


}
