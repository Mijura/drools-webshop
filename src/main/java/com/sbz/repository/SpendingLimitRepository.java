package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbz.models.SpendingLimit;

public interface SpendingLimitRepository extends JpaRepository<SpendingLimit, Long>{

}
