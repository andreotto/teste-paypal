package com.netshoes.paypal.conf.feign;

import com.netshoes.paypal.gateways.RedisGateway;
import com.netshoes.paypal.gateways.feign.TokenFeignPaypal;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;

@RequiredArgsConstructor
public class TokenInterceptor implements RequestInterceptor {

  private final TokenFeignPaypal tokenFeignPaypal;
  private RedisGateway redisGateway;

  @Override
  public void apply(RequestTemplate requestTemplate) {
    //Token token = redisGateway.getAccessToken();
    //if (token == null) {
    Token token = tokenFeignPaypal.getTokenPaypal("client_credentials");
    //}
    requestTemplate.header(HttpHeaders.AUTHORIZATION, "Bearer " + token.getAccess_token());
  }
}
