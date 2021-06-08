package meli.bootcamp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Publication implements Comparable<Publication> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_of_publication")
    private LocalDate date;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Product product;
    private Integer category;
    private Double price;
    @JsonIgnore
    private Integer seller_id;
    private Boolean hasPromo;
    private Double discount;

    @Override
    public int compareTo(Publication o) {
        int isBefore = 0;

        if (this.date.isBefore(o.date)){
            isBefore = 1;
        } else{
            isBefore = -1;
        }

        return isBefore;
    }
}