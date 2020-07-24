package starts.play.payment.plans.dto;

import lombok.*;
import starts.play.payment.plans.entity.PaymentMethods;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class RequestPaymentMethod implements Serializable {
    private List<PaymentMethods> paymentMethods;
}
