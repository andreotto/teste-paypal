package com.netshoes.paypal.conf.feign;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "paypal.credentials")
public class PaypalCredentials {
  private String clientID;
  private String secret;
  private String url;
}
