package com.GBG.gestiondesupermarche.services;

import com.GBG.gestiondesupermarche.dto.LigneVenteDto;

import java.util.List;

public interface ligneVenteService {

    List<LigneVenteDto> getByIdVente(Integer id);
}
