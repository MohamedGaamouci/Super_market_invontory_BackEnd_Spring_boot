package com.GBG.gestiondesupermarche.repository;

import com.GBG.gestiondesupermarche.model.Ventes;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

  Optional<Ventes> findVentesByCode(String code);
}
