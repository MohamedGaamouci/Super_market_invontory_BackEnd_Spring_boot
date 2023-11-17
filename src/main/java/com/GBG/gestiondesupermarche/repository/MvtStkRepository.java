package com.GBG.gestiondesupermarche.repository;

import com.GBG.gestiondesupermarche.model.MvtStk;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {

  @Query(value = "SELECT sum(quantite) FROM mvtstk where idarticle =?1", nativeQuery = true)
  BigDecimal stockReelArticle(@Param(value = "idArticle") Integer idArticle);

  List<MvtStk> findAllByArticleId(Integer idArticle);

}
