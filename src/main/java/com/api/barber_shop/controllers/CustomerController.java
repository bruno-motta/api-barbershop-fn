package com.api.barber_shop.controllers;

import com.api.barber_shop.dtos.CustomerRequestDto;
import com.api.barber_shop.dtos.CustomerResponseDto;
import com.api.barber_shop.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDto> registerCustomer (@RequestBody @Valid CustomerRequestDto requestDto){
        CustomerResponseDto responseDto = customerService.saveCustomer(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/email")
    public ResponseEntity<CustomerResponseDto> searchCustomerByEmail(@RequestParam String email){
        CustomerResponseDto responseDto = customerService.searchCustomerEmail(email);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustumer(@PathVariable UUID id,
                                                              @RequestBody CustomerRequestDto requestDto){
        CustomerResponseDto response = customerService.updateCustomer(id, requestDto);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id){
        customerService.deteleCustomer(id);
        return ResponseEntity.ok().build();
    }

}
