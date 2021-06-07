package meli.bootcamp.rest.dto;

import lombok.Data;


@Data
public class PublicationRequestDTO {
    private Integer userId;
    private String date;
    private DetailDTO detail;
    private Integer category;
    private Double price;

    @Override
    public String toString() {
        return "PublicationRequestDTO{" +
                "userId=" + userId + "\n" +
                ", date='" + date + "\n" +
                ", details=" + detail.toString() + "\n" +
                ", category=" + category + "\n" +
                ", price=" + price +
                '}';
    }
}





