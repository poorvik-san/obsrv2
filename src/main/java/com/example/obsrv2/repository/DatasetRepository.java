package com.example.obsrv2.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.obsrv2.entity.Dataset;

import jakarta.persistence.LockModeType;


import java.util.Optional;



public interface DatasetRepository extends JpaRepository<Dataset, String > {
    

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM Dataset d WHERE d.id = :id")
    Optional<Dataset> findByIdForUpdate(@Param("id") String id);
}
