package starts.play.payment.plans.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import starts.play.payment.plans.dto.RequestPaymentMethod;
import starts.play.payment.plans.dto.ResponsePaymentMethod;
import starts.play.payment.plans.service.PaymentMethodsService;

import java.util.Objects;

@RestController
public class PaymentMethodsResource {

    private final Logger LOG = LoggerFactory.getLogger(PaymentMethodsResource.class);

    //@Autowired
   // private RestTemplate restTemplate;

    private PaymentMethodsService paymentMethodsService;

    public PaymentMethodsResource(PaymentMethodsService paymentMethodsService) {
        this.paymentMethodsService = paymentMethodsService;
    }

    @RequestMapping("/hello")
    public String hello(){

        final String uri = "http://localhost:8080/api/v1.0/configuration/payment-methods";

        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<ResponsePaymentMethod> result = restTemplate.getForObject(uri, ResponseEntity.class);

        ResponseEntity<ResponsePaymentMethod> responseEntity = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponsePaymentMethod>() {
                });
        ResponsePaymentMethod body = responseEntity.getBody();

        LOG.info("=============result: " + body);

        return "hello";
    }

    @RequestMapping("/helloWord")
    public String helloWord(){
        return "Hello Word";
    }

    @PostMapping("/api/v1.0/configuration/payment-methods")
    public ResponseEntity<ResponsePaymentMethod> addPaymentMethod(@RequestBody RequestPaymentMethod request){
        return ResponseEntity.ok(new ResponsePaymentMethod(paymentMethodsService.addPaymentMethod(request)));
    }

    @GetMapping("/api/v1.0/configuration/payment-methods")
    public ResponseEntity<ResponsePaymentMethod> getPaymentMethods(@RequestParam (name = "name", required = false) String name,
                                                   @RequestParam (name = "id", required = false) Long id){
        return ResponseEntity.ok(new ResponsePaymentMethod(paymentMethodsService.getPaymentMethods(name, id)));
    }

    @PutMapping("/api/v1.0/configuration/payment-methods")
    public ResponseEntity<ResponsePaymentMethod> updatePaymentMethod(
                                                @RequestParam (name = "payment-methods", required = true) Long id,
                                                @RequestBody RequestPaymentMethod request){

        if(Objects.isNull(id) || id <= 0)
            return ResponseEntity.badRequest().body(null);

        return ResponseEntity.ok(new ResponsePaymentMethod(paymentMethodsService.updatePaymentMethod(request, id)));
    }
}
