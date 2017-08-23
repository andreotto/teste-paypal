package com.netshoes.paypal.gateways;

import com.netshoes.paypal.conf.feign.Token;

public interface PaypalGateway {

  Token getTokenFromPaypal();
}
