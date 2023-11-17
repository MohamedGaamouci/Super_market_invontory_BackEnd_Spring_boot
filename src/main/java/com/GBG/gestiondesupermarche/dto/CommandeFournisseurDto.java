package com.GBG.gestiondesupermarche.dto;

import com.GBG.gestiondesupermarche.model.CommandeFournisseur;
import com.GBG.gestiondesupermarche.model.EtatCommande;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandeFournisseurDto {

  private Integer id;

  private String code;

  private Instant dateCommande;

  private EtatCommande etatCommande;

  private FournisseurDto fournisseur;

  private Integer idEntreprise;

  private BigDecimal total;

  private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

  public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
    if (commandeFournisseur == null) {
      return null;
    }
    return CommandeFournisseurDto.builder()
        .id(commandeFournisseur.getId())
        .code(commandeFournisseur.getCode())
        .dateCommande(commandeFournisseur.getDateCommande())
        .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
        .etatCommande(commandeFournisseur.getEtatCommande())
        .idEntreprise(commandeFournisseur.getIdEntreprise())
            .total(commandeFournisseur.getTotal())
        .build();
  }

  public static CommandeFournisseur toEntity(CommandeFournisseurDto dto) {
    if (dto == null) {
      return null;
    }
    CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
    commandeFournisseur.setId(dto.getId());
    commandeFournisseur.setCode(dto.getCode());
    commandeFournisseur.setDateCommande(dto.getDateCommande());
    commandeFournisseur.setFournisseur(FournisseurDto.toEntity(dto.getFournisseur()));
    commandeFournisseur.setIdEntreprise(dto.getIdEntreprise());
    commandeFournisseur.setEtatCommande(dto.getEtatCommande());
    commandeFournisseur.setTotal(dto.getTotal());
    return commandeFournisseur;
  }

  public boolean isCommandeLivree() {
    return EtatCommande.LIVREE.equals(this.etatCommande);
  }

}
