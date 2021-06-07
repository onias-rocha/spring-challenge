package meli.bootcamp.rest;

import meli.bootcamp.entity.Publication;
import meli.bootcamp.rest.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ChallengeController {
    //US 0001
    public HttpStatus followUserById (@PathVariable Integer idUser, @PathVariable Integer idToFollow);

    //US 0002
    public FollowersCountDTO getAmmountOfFollowers(@PathVariable Integer userId);

    //US 0003
    public List<CustomerDTO> listAllFollowers(@PathVariable Integer userId);

    //US 0004
    public List<SellerDTO> listAllSellers(@PathVariable Integer userId);

    //US 0005
    public HttpStatus createNewPublication(@RequestBody PublicationRequestDTO publication);

    //US 0006
    public List<Publication> listPublicationsByIdAndDate(@PathVariable Integer userId);

}
