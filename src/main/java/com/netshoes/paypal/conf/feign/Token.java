package com.netshoes.paypal.conf.feign;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Token {
    private String scope;
    private String nonce;
    private String access_token;
    private String token_type;
    private String app_id;
    private String expires_in;

}
