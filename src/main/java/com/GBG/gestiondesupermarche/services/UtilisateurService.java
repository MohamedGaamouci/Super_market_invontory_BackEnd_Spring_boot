package com.GBG.gestiondesupermarche.services;

import com.GBG.gestiondesupermarche.dto.ChangerMotDePasseUtilisateurDto;
import com.GBG.gestiondesupermarche.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

  UtilisateurDto save(UtilisateurDto dto);

  UtilisateurDto findById(Integer id);

  List<UtilisateurDto> findAll();

  void delete(Integer id);

  UtilisateurDto findByEmail(String email);

  UtilisateurDto changerMotDePasse(ChangerMotDePasseUtilisateurDto dto);


}
