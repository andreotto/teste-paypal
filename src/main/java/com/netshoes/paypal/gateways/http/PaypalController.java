package com.netshoes.paypal.gateways.http;

import com.netshoes.paypal.usecases.PaypalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/paypal")
public class PaypalController {

    private final PaypalService paypalService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    public ResponseEntity getToken(){
        paypalService.getToken();
        return ResponseEntity.ok().build();
    }
}
