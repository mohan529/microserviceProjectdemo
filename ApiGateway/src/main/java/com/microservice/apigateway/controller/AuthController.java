package com.microservice.apigateway.controller;

import com.microservice.apigateway.models.AuthReesponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger log= LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/login")
    public ResponseEntity<AuthReesponse> loging(
            @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OidcUser user,
            Model model){

        log.info("user email id: {}",user.getEmail());
        AuthReesponse authReesponse=new AuthReesponse();
        authReesponse.setUserId(user.getEmail());
        authReesponse.setAccessToken(client.getAccessToken().getTokenValue());
        authReesponse.setRefreshToken(client.getRefreshToken().getTokenValue());
        authReesponse.setExpiredAt(client.getAccessToken().getExpiresAt().getEpochSecond());
        List<String> authorities=user.getAuthorities().stream().map(grantedAuthority -> {
            return grantedAuthority.getAuthority();
        }).collect(Collectors.toList());

        authReesponse.setAuthorities(authorities);

    return  new ResponseEntity<>(authReesponse, HttpStatus.OK);
    }
}
