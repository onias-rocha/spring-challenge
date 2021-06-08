package meli.bootcamp.rest.dto;

import lombok.Data;

@Data
public class PromoPublicationRequestDTO {
    private Integer userId;
    private String date;
    private DetailDTO detail;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
