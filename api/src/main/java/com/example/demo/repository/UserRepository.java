package com.example.demo.repository;


import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByCiudad(String ciudad);

    List<User> findUserByFechaAltaIsAfter(LocalDate fechaAlta);

    Optional<User> findById(Long id);

}
