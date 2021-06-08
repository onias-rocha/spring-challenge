package meli.bootcamp.rest.dto;

import lombok.Data;

@Data
public class PromoPostsCountDTO {
    private Integer userId;
    private String userName;
    private Integer promoproducts_count;
}
