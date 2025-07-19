package com.api.barber_shop.repositorys;

import com.api.barber_shop.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    Optional<CustomerEntity> findByEmailCustomer(String emailCustomer);

    @Transactional
    void deleteByEmailCustomer(String emailCustomer);
}
