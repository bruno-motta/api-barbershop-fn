package com.api.barber_shop.domain.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "services")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_service", nullable = false)
    private UUID idService;

    @Column(name = "name_service")
    private String nameService;

    @Column(name = "duration_min_service")
    private Integer durationMinService;

    @Column(name = "price_service")
    private BigDecimal priceService;

    @Column(name = "active_service")
    private Boolean activeService;
}

