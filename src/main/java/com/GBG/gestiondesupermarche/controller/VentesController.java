package com.GBG.gestiondesupermarche.controller;


import com.GBG.gestiondesupermarche.controller.api.VentesApi;
import com.GBG.gestiondesupermarche.dto.LigneVenteDto;
import com.GBG.gestiondesupermarche.dto.VentesDto;
import com.GBG.gestiondesupermarche.services.VentesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.GBG.gestiondesupermarche.services.ligneVenteService;

@RestController
public class VentesController implements VentesApi {

  private VentesService ventesService;
  private ligneVenteService ligneVenteService;

  @Autowired
  public VentesController(VentesService ventesService,ligneVenteService ligneVenteService) {
    this.ventesService = ventesService;
    this.ligneVenteService = ligneVenteService;
  }

  @Override
  public VentesDto save(VentesDto dto) {

    return ventesService.save(dto);
  }

  @Override
  public List<LigneVenteDto> findallbyventeId(Integer id) {
    System.out.println("controler id  :: "+id);
    return (List<LigneVenteDto>) ligneVenteService.getByIdVente(id);
  }

  @Override
  public VentesDto findById(Integer id) {
    return ventesService.findById(id);
  }

  @Override
  public VentesDto findByCode(String code) {
    return ventesService.findByCode(code);
  }

  @Override
  public List<VentesDto> findAll() {
    return ventesService.findAll();
  }

  @Override
  public void delete(Integer id) {
    ventesService.delete(id);
  }
}
