package com.api.barber_shop.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product", nullable = false)
    private UUID idService;

    @Column(name = "name_product")
    private String nameService;

    @Column(name = "duration_min_product")
    private Integer durationMinService;

    @Column(name = "price_product")
    private BigDecimal priceService;

    @Column(name = "active_product")
    private Boolean activeService;
}

