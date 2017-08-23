package com.netshoes.paypal.gateways.feign.impl;

import com.netshoes.paypal.conf.feign.Token;
import com.netshoes.paypal.gateways.PaypalGateway;
import com.netshoes.paypal.gateways.RedisGateway;
import com.netshoes.paypal.gateways.feign.TokenFeignPaypal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaypalGatewayImpl implements PaypalGateway {

  private final RedisGateway redisGateway;
  private final TokenFeignPaypal tokenFeignPaypal;

  @Override
  public Token getTokenFromPaypal() {
    return tokenFeignPaypal.getTokenPaypal("client_credentials");
  }
}
