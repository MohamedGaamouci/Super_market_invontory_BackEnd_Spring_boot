package com.GBG.gestiondesupermarche.controller;


import com.GBG.gestiondesupermarche.controller.api.AuthenticationApi;
import com.GBG.gestiondesupermarche.dto.auth.AuthenticationRequest;
import com.GBG.gestiondesupermarche.dto.auth.AuthenticationResponse;
import com.GBG.gestiondesupermarche.model.auth.ExtendedUser;
import com.GBG.gestiondesupermarche.utils.JwtUtil;
import com.GBG.gestiondesupermarche.services.auth.ApplicationUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController implements AuthenticationApi {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private ApplicationUserDetailsService userDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  @Override
  public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getLogin(),
            request.getPassword()
        )
    );
    final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());

    final String jwt = jwtUtil.generateToken((ExtendedUser) userDetails);

    return ResponseEntity.ok(AuthenticationResponse.builder().accessToken(jwt).build());
  }

}
