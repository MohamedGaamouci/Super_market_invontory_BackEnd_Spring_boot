package com.GBG.gestiondesupermarche.controller.api;

import com.GBG.gestiondesupermarche.dto.auth.AuthenticationRequest;
import com.GBG.gestiondesupermarche.dto.auth.AuthenticationResponse;
import com.GBG.gestiondesupermarche.utils.Constants;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api("authentication")
public interface AuthenticationApi {

  @PostMapping(Constants.AUTHENTICATION_ENDPOINT + "/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request);

}
