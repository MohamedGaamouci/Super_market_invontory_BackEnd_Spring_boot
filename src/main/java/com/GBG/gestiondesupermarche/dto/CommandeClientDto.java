package com.GBG.gestiondesupermarche.dto;

import com.GBG.gestiondesupermarche.model.CommandeClient;
import com.GBG.gestiondesupermarche.model.EtatCommande;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class CommandeClientDto {

  private Integer id;

  private String code;

  private Instant dateCommande;

  private EtatCommande etatCommande;

  private ClientDto client;

  private Integer idEntreprise;

  private BigDecimal total;

  private List<LigneCommandeClientDto> ligneCommandeClients;

  public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
    if (commandeClient == null) {
      return null;
    }
    return CommandeClientDto.builder()
        .id(commandeClient.getId())
        .code(commandeClient.getCode())
        .dateCommande(commandeClient.getDateCommande())
        .etatCommande(commandeClient.getEtatCommande())
        .client(ClientDto.fromEntity(commandeClient.getClient()))
        .idEntreprise(commandeClient.getIdEntreprise())
            .total(commandeClient.getTotal())
        .build();

  }

  public static CommandeClient toEntity(CommandeClientDto dto) {
    if (dto == null) {
      return null;
    }
    CommandeClient commandeClient = new CommandeClient();
    commandeClient.setId(dto.getId());
    commandeClient.setCode(dto.getCode());
    commandeClient.setClient(ClientDto.toEntity(dto.getClient()));
    commandeClient.setDateCommande(dto.getDateCommande());
    commandeClient.setEtatCommande(dto.getEtatCommande());
    commandeClient.setIdEntreprise(dto.getIdEntreprise());
    commandeClient.setTotal(dto.getTotal());
    return commandeClient;
  }

  public boolean isCommandeLivree() {
    return EtatCommande.LIVREE.equals(this.etatCommande);
  }
}
