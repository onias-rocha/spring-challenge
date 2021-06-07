package meli.bootcamp.rest.dto;

import lombok.Data;

@Data
public class FollowersCountDTO {
    private Integer userId;
    private String userName;
    private Integer followersCount = 0;
}
