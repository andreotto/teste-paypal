package com.netshoes.paypal.usecases;

import com.netshoes.paypal.conf.feign.Token;
import com.netshoes.paypal.gateways.PaypalGateway;
import com.paypal.api.payments.CreditCard;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaypalService {

    private final PaypalGateway paypalGateway;

    public void getToken(){
        Token token = paypalGateway.getTokenFromPaypal();
        log.info(token.toString());
    }


    //@PostConstruct
    public void init() {

        String clientId = "AWB_RlhsmngFihisdHcpptyoN6rvyKJN62uhlJHExey_Rsyxgf608RtZpHp9IzdkbKlMFUkdQpKZiipk";
        String clientSecret = "EMnA-s0AuhoTbZ9nodJ1Ei_BIUfisfOgaO0w7Ui5T8h0NwEHxD-4_DwqG_ToAbCEj-7UMb-TbakwAg8H";

        CreditCard card = new CreditCard()
                .setType("visa")
                .setNumber("4417119669820331")
                .setExpireMonth(11)
                .setExpireYear(2019)
                .setCvv2("012")
                .setFirstName("Joe")
                .setLastName("Shopper");

        try {
            APIContext context = new APIContext(clientId, clientSecret, "sandbox");
            card.create(context);
            System.out.println(card.toJSON());
        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
        }
    }
}
