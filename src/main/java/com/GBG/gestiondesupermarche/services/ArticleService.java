package com.GBG.gestiondesupermarche.services;

import com.GBG.gestiondesupermarche.dto.ArticleDto;
import com.GBG.gestiondesupermarche.dto.LigneCommandeClientDto;
import com.GBG.gestiondesupermarche.dto.LigneCommandeFournisseurDto;
import com.GBG.gestiondesupermarche.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

  ArticleDto save(ArticleDto dto);

  ArticleDto findById(Integer id);

  ArticleDto findByCodeArticle(String codeArticle);

  List<ArticleDto> findAll();

  List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

  List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

  List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

  List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

  void delete(Integer id);

}
