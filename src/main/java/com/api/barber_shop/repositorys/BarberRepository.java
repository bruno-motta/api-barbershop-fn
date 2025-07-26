package com.api.barber_shop.repositorys;

import com.api.barber_shop.entity.BarberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BarberRepository extends JpaRepository<BarberEntity, UUID> {

    //Containg busca parcialmente(contém dentro) e ignora maiuscula e minuscula na comparação.
    List<BarberEntity> findByNameBarberContainingIgnoreCase(String nameBarber);

    List<BarberEntity> findBySpecialtyBarberContainingIgnoreCase(String specialtyBarber);

    //Buscas pelos dois(name/especialidade)
    List<BarberEntity> findByNameBarberContainingIgnoreCaseAndSpecialtyBarberContainingIgnoreCase(String name, String epecialty);
}
