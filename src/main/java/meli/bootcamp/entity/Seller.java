package meli.bootcamp.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    @JoinTable(
            name="seller_customer",
            joinColumns = @JoinColumn(name="seller_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id")
    )
    private List<Customer> followers;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="seller_id")
    private List<Publication> publications;
}
