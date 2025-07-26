package com.api.barber_shop.entity;

import com.api.barber_shop.entity.enums.ActiveBarber;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "barber")
@Entity
public class BarberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barber", nullable = false)
    private UUID id;

    @Column(name = "name_barber", nullable = false)
    private String nameBarber;

    @Column(name = "specialty_barber", nullable = false)
    private String specialtyBarber;

    @Column(name = "Active_barber", nullable = false)
    private ActiveBarber activeBarber;

}
