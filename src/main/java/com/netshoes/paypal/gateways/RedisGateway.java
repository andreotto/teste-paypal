package com.netshoes.paypal.gateways;

import com.netshoes.paypal.conf.feign.Token;

public interface RedisGateway {

    public Token getAccessToken();
}
