package com.empresa.cruddeforestacionapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.cruddeforestacionapi.entity.AreaCriticaEntity;

@Repository
public interface AreaCriticaRepository extends JpaRepository<AreaCriticaEntity, Long>{
    
}
