package meli.bootcamp.rest.dto;

import lombok.Data;
import meli.bootcamp.entity.Customer;

@Data
public class CustomerDTO implements Comparable<CustomerDTO>{
    private Integer id;
    private String nome;


    @Override
    public int compareTo(CustomerDTO o) {
        return this.nome.compareTo(o.getNome());
    }
}
