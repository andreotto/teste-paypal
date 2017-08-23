package com.netshoes.paypal.gateways.feign;

import com.netshoes.paypal.conf.feign.Token;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface TokenFeignPaypal {

  @RequestLine(value = "POST /oauth2/token")
  @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept-Language: en_US"})
  //@Body("%7B\"grant_type\": \"client_credentials\"%7D")
  Token getTokenPaypal(@Param("grant_type") String grant_type);
}
