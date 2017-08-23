package com.netshoes.paypal.conf.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netshoes.paypal.gateways.feign.TokenFeignPaypal;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.form.FormEncoder;
import feign.jackson.JacksonDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class FeingConfig {

  private final ObjectMapper mapper;
  private final SpringWebClientErrorDecoder errorDecoder;
  private final PaypalCredentials paypalCredentials;

  @Bean
  public TokenFeignPaypal tokenFeignPaypal() {
    return Feign.builder()
        .encoder(new FormEncoder())
        .decoder(new JacksonDecoder(mapper))
        .errorDecoder(errorDecoder)
        //.logger(new Slf4jLogger())
        .logLevel(Logger.Level.FULL)
        .requestInterceptor(
            new BasicAuthRequestInterceptor(
                paypalCredentials.getClientID(), paypalCredentials.getSecret()))
        .target(TokenFeignPaypal.class, paypalCredentials.getUrl());
  }
}
