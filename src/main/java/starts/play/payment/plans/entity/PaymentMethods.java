package starts.play.payment.plans.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * A PaymentMethods.
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Table(name = "abs_payment_methods")
public class PaymentMethods implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "abs_payment_methods_sequence", sequenceName = "abs_payment_methods_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "abs_payment_methods_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Size(min = 1)
    @Column(name = "display_name", nullable = false)
    private String displayName;

    @NotNull
    @Size(min = 1)
    @Column(name = "payment_type", nullable = false)
    private String paymentType;

    @OneToMany(targetEntity = PaymentPlans.class, cascade = CascadeType.ALL)
    @JoinColumn(name="payment_method_id", referencedColumnName = "id")
    private List<PaymentPlans> paymentPlans;

}
