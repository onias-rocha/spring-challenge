package meli.bootcamp.rest;

import lombok.Data;

@Data
public class FollowersCountDTO {
    private Integer userId;
    private String userName;
    private Integer followersCount = 0;
}
