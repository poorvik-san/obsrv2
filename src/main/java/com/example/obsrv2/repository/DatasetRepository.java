package com.example.obsrv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.obsrv2.entity.Dataset;

public interface DatasetRepository extends JpaRepository<Dataset, String> {
}
