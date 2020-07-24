package starts.play.payment.plans.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import starts.play.payment.plans.entity.PaymentMethods;

import java.util.List;

public interface PaymentMethodRepositry extends JpaRepository<PaymentMethods, Integer> {

    List<PaymentMethods> getPaymentMethodsByName(String name);

    List<PaymentMethods> findAllById(long id);
}
