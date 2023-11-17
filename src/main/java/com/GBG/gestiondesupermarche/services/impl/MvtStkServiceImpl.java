package com.GBG.gestiondesupermarche.services.impl;

import com.GBG.gestiondesupermarche.dto.MvtStkDto;
import com.GBG.gestiondesupermarche.exception.ErrorCodes;
import com.GBG.gestiondesupermarche.exception.InvalidEntityException;
import com.GBG.gestiondesupermarche.model.TypeMvtStk;
import com.GBG.gestiondesupermarche.repository.MvtStkRepository;
import com.GBG.gestiondesupermarche.validator.MvtStkValidator;
import com.GBG.gestiondesupermarche.services.ArticleService;
import com.GBG.gestiondesupermarche.services.MvtStkService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.*;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

  private MvtStkRepository repository;
  private ArticleService articleService;

  @Autowired
  public MvtStkServiceImpl(MvtStkRepository repository, ArticleService articleService) {
    this.repository = repository;
    this.articleService = articleService;
  }

  @Override
  public BigDecimal stockReelArticle(Integer idArticle) {
    if (idArticle == null) {
      log.warn("ID article is NULL");
      return BigDecimal.valueOf(-1);
    }
    articleService.findById(idArticle);

    BigDecimal result = null;
    System.out.println("----"+idArticle);
    try {
      result = repository.stockReelArticle(idArticle);
    } catch (Exception e) {
      log.error("error msg " + e.toString());
    }

    return result;
  }

  @Override
  public List<MvtStkDto> mvtStkArticle(Integer idArticle) {
    return repository.findAllByArticleId(idArticle).stream()
        .map(MvtStkDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public MvtStkDto entreeStock(MvtStkDto dto) {
    return entreePositive(dto, TypeMvtStk.ENTREE);
  }

  @Override
  public MvtStkDto sortieStock(MvtStkDto dto) {
    return sortieNegative(dto, TypeMvtStk.SORTIE);
  }

  @Override
  public MvtStkDto correctionStockPos(MvtStkDto dto) {
    return entreePositive(dto, TypeMvtStk.CORRECTION_POS);
  }

  @Override
  public MvtStkDto correctionStockNeg(MvtStkDto dto) {
    return sortieNegative(dto, TypeMvtStk.CORRECTION_NEG);
  }

  private MvtStkDto entreePositive(MvtStkDto dto, TypeMvtStk typeMvtStk) {
    List<String> errors = MvtStkValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
    }
    dto.setQuantite(
        BigDecimal.valueOf(
            Math.abs(dto.getQuantite().doubleValue())
        )
    );
    dto.setTypeMvt(typeMvtStk);
    return MvtStkDto.fromEntity(
        repository.save(MvtStkDto.toEntity(dto))
    );
  }

  private MvtStkDto sortieNegative(MvtStkDto dto, TypeMvtStk typeMvtStk) {
    List<String> errors = MvtStkValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalidEntityException("Le mouvement du stock n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
    }
    dto.setQuantite(
        BigDecimal.valueOf(
            Math.abs(dto.getQuantite().doubleValue()) * -1
        )
    );
    dto.setTypeMvt(typeMvtStk);
    return MvtStkDto.fromEntity(
        repository.save(MvtStkDto.toEntity(dto))
    );
  }
}
