package com.GBG.gestiondesupermarche.controller.api;


import com.GBG.gestiondesupermarche.dto.FournisseurDto;
import com.GBG.gestiondesupermarche.utils.Constants;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("fournisseur")
public interface FournisseurApi {

  @PostMapping(Constants.FOURNISSEUR_ENDPOINT + "/create")
  FournisseurDto save(@RequestBody FournisseurDto dto);

  @GetMapping(Constants.FOURNISSEUR_ENDPOINT + "/{idFournisseur}")
  FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

  @GetMapping(Constants.FOURNISSEUR_ENDPOINT + "/all")
  List<FournisseurDto> findAll();

  @DeleteMapping(Constants.FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}")
  void delete(@PathVariable("idFournisseur") Integer id);

}
