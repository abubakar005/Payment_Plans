package starts.play.payment.plans.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import starts.play.payment.plans.entity.PaymentPlans;

public interface PaymentPlansRepositry extends JpaRepository<PaymentPlans, Integer> {
}
