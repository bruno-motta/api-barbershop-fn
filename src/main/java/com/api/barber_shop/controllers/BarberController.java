package com.api.barber_shop.controllers;

import com.api.barber_shop.dtos.BarberRequestDto;
import com.api.barber_shop.dtos.BarberResponseDto;
import com.api.barber_shop.services.BarberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping("/{id}")
    public ResponseEntity<BarberResponseDto> upadateBarber(@PathVariable UUID id,
                                                           @RequestBody BarberRequestDto requestDto){
        BarberResponseDto updateResponse=  barberService.updateBarber(id, requestDto);
        return ResponseEntity.ok(updateResponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarberId(@PathVariable UUID id){
        barberService.deleteBarberId(id);
        return ResponseEntity.noContent().build();
    }





}
