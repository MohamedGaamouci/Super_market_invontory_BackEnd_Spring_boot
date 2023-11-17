package com.GBG.gestiondesupermarche.services.impl;
import com.GBG.gestiondesupermarche.dto.LigneVenteDto;

import com.GBG.gestiondesupermarche.repository.LigneVenteRepository;
import com.GBG.gestiondesupermarche.services.ligneVenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ligneVenteServiceImpl implements ligneVenteService{

    LigneVenteRepository ligneVenteRepository;
    @Autowired
    ligneVenteServiceImpl(LigneVenteRepository ligneVenteRepository){
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public List<LigneVenteDto> getByIdVente(Integer id) {
        System.out.println("service id  :: "+id);
        List<LigneVenteDto> a = ligneVenteRepository.findAllByVenteId(id).stream()
                .map(LigneVenteDto::fromEntity)
                .collect(Collectors.toList());
        System.out.println(a.toString());
        return a;

    }
}
