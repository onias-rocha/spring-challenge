package meli.bootcamp.rest;

import meli.bootcamp.entity.Publication;
import meli.bootcamp.rest.dto.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ChallengeController {
    //US 0001
    public HttpStatus followUserById (Integer idUser, Integer idToFollow);

    //US 0002
    public FollowersCountDTO getAmmountOfFollowers(Integer userId);

    //US 0003
    public List<CustomerDTO> listAllFollowers(Integer userId, String order);

    //US 0004
    public List<SellerDTO> listAllSellers(Integer userId, String order);

    //US 0005
    public HttpStatus createNewPublication(PublicationRequestDTO publication);

    //US 0006
    public List<Publication> listPublicationsByIdAndDate(Integer userId, String order);

    //US 0007
    public HttpStatus unfollowSeller(Integer userId, Integer sellerId);

    //US 0010
    public HttpStatus createNewPromoPost(PromoPublicationRequestDTO promoPublication);
}
