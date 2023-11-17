package com.GBG.gestiondesupermarche.repository;

import com.GBG.gestiondesupermarche.model.Category;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

  Optional<Category> findCategoryByCode(String code);

}
