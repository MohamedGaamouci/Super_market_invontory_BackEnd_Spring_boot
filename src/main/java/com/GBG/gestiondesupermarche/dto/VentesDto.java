package com.GBG.gestiondesupermarche.dto;

import com.GBG.gestiondesupermarche.model.Ventes;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class VentesDto {

  private Integer id;

  private String code;
  private BigDecimal total;

  private Instant dateVente;

  private String commentaire;

  @Setter
  @Getter
  private List<LigneVenteDto> ligneVentes;

  private Integer idEntreprise;

  public static VentesDto fromEntity(Ventes vente) {
    if (vente == null) {
      return null;
    }
    return VentesDto.builder()
        .id(vente.getId())
        .code(vente.getCode())
        .total(vente.getTotal())
        .commentaire(vente.getCommentaire())
        .idEntreprise(vente.getIdEntreprise())
        .build();
  }

  public static Ventes toEntity(VentesDto dto) {
    if (dto == null) {
      return null;
    }
    Ventes ventes = new Ventes();
    ventes.setId(dto.getId());
    ventes.setCode(dto.getCode());
    ventes.setTotal(dto.getTotal());
    ventes.setCommentaire(dto.getCommentaire());
    ventes.setDateVente(dto.getDateVente());
    ventes.setIdEntreprise(dto.getIdEntreprise());

    return ventes;
  }
}
