package com.sbz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbz.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findOneByName(String name);

}
