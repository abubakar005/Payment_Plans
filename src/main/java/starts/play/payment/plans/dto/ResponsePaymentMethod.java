package starts.play.payment.plans.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import starts.play.payment.plans.entity.PaymentMethods;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponsePaymentMethod {
    private List<PaymentMethods> paymentMethods;
}
