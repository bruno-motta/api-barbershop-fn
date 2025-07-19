package com.api.barber_shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id", nullable = false)
    private UUID id;

    @Column(name = "name_customer", nullable = false, length = 100)
    private String nameCustomer;

    @Column(name = "email_customer", nullable = false, length = 100)
    private String emailCustomer;

    @Column(name = "telephone_customer", nullable = false, length = 15)
    private String telephoneCustomer;

    @Column(name = "dataTimeRegistration", nullable = false)
    private LocalDateTime dateTimeResgistration = LocalDateTime.now();


}
