package meli.bootcamp.rest.dto;

import lombok.Data;
import meli.bootcamp.entity.Publication;

import java.util.List;

@Data
public class PromoPostsByUserDTO {
    private Integer userId;
    private String userName;
    private List<Publication> posts;
}
