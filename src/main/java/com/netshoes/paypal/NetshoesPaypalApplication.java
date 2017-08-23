package com.netshoes.paypal;

import com.netshoes.paypal.usecases.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class NetshoesPaypalApplication {

  @Autowired private PaypalService paypalService;

  public static void main(String[] args) {
    SpringApplication.run(NetshoesPaypalApplication.class, args);
  }

  @PostConstruct
  public void init() {
    paypalService.getToken();
  }
}
