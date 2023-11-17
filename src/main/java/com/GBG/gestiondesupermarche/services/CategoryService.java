package com.GBG.gestiondesupermarche.services;

import com.GBG.gestiondesupermarche.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

  CategoryDto save(CategoryDto dto);

  CategoryDto findById(Integer id);

  CategoryDto findByCode(String code);

  List<CategoryDto> findAll();

  void delete(Integer id);

}
