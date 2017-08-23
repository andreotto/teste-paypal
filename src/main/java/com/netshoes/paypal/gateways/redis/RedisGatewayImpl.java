package com.netshoes.paypal.gateways.redis;

import com.netshoes.paypal.conf.feign.Token;
import com.netshoes.paypal.gateways.RedisGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RedisGatewayImpl implements RedisGateway {

    @Override
    public Token getAccessToken() {
        return null;
    }
}
