package starts.play.payment.plans.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * A PaymentPlans.
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "abs_payment_plans")
public class PaymentPlans implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "net_amount", nullable = false)
    private Double netAmount;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "tax_amount", nullable = false)
    private Double taxAmount;

    @NotNull
    @DecimalMin(value = "0")
    @Column(name = "gross_amount", nullable = false)
    private Double grossAmount;

    @NotNull
    @Size(min = 3)
    @Column(name = "currency", nullable = false)
    private String currency;

    @NotNull
    @Size(min = 3)
    @Column(name = "duration", nullable = false)
    private String duration;

}
