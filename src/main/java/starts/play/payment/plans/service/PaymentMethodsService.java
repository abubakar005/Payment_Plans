package starts.play.payment.plans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import starts.play.payment.plans.dto.RequestPaymentMethod;
import starts.play.payment.plans.entity.PaymentMethods;
import starts.play.payment.plans.repositry.PaymentMethodRepositry;
import starts.play.payment.plans.repositry.PaymentPlansRepositry;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.springframework.util.StringUtils.hasText;

@Transactional
@Service
public class PaymentMethodsService {

    @Autowired
    private PaymentMethodRepositry paymentMethodRepositry;

    @Autowired
    private PaymentPlansRepositry paymentPlansRepositry;


    public List<PaymentMethods> addPaymentMethod(RequestPaymentMethod request){
        return Arrays.asList(paymentMethodRepositry.save(request.getPaymentMethods().get(0)));
    }

    public List<PaymentMethods> getPaymentMethods(String name, Long id){

        if(!Objects.isNull(id) && id > 0)
            return paymentMethodRepositry.findAllById(id);
        else if(StringUtils.hasText(name))
            return paymentMethodRepositry.getPaymentMethodsByName(name);
        else
            return paymentMethodRepositry.findAll();
    }

    public List<PaymentMethods> updatePaymentMethod(RequestPaymentMethod request, long id){

        PaymentMethods paymentMethod = request.getPaymentMethods().get(0);
        paymentMethod.setId(id);
        return Arrays.asList(paymentMethodRepositry.save(paymentMethod));
    }

//    public String pickLuckyNameWOrElse(final List<String> names, final String startingLetter) {
//        final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
//        return luckyName.orElse("No lucky name found");
//    }

}
