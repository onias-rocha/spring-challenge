package meli.bootcamp.rest;

import lombok.Data;

@Data
public class SellerDTO implements Comparable<SellerDTO>{
    private Integer id;
    private String nome;

    @Override
    public int compareTo(SellerDTO o) {
        return this.nome.compareTo(o.getNome());
    }
}
