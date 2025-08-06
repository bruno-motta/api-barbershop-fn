package com.api.barber_shop.controllers;

import com.api.barber_shop.dtos.BarberRequestDto;
import com.api.barber_shop.dtos.BarberResponseDto;
import com.api.barber_shop.services.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/barber")
public class BarberController {

    private final BarberService barberService;


    @PostMapping("/cadastro")
    public ResponseEntity<BarberResponseDto> createBarber(@RequestBody BarberRequestDto requestDto) {
        BarberResponseDto responseDto = barberService.createBarber(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/nome")
    public ResponseEntity<List<BarberResponseDto>> findyByIdBarber(@RequestParam String name){
       List<BarberResponseDto> responseBarber = barberService.findByNameBarber(name);
        return ResponseEntity.ok(responseBarber);
    }






}
