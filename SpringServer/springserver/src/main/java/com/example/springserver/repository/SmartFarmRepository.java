package com.example.springserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springserver.domain.SmartFarm;

public interface SmartFarmRepository extends JpaRepository<SmartFarm, Long> {

}
