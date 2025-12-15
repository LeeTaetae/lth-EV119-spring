package com.app.ev119.repository;


import com.app.ev119.domain.entity.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProceduresRepository extends JpaRepository<Procedures, Long> {
    public Procedures save(Procedures procedure);
    public Optional<Procedures> findById(Long id);
}
