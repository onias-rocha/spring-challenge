package meli.bootcamp.rest;

import meli.bootcamp.entity.Customer;
import meli.bootcamp.entity.Seller;
import meli.bootcamp.service.CustomerService;
import meli.bootcamp.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    CustomerService c_service;
    SellerService s_service;

    public ChallengeController(CustomerService c_service, SellerService s_service) {
        this.c_service = c_service;
        this.s_service = s_service;
    }

    @PostMapping("/users/{idUser}/follow/{idToFollow}")
    public HttpStatus followUserById (@PathVariable Integer idUser, @PathVariable Integer idToFollow){
        Customer c1 = c_service.getCustomerById(idUser);
        Seller s1 = s_service.getSellerById(idToFollow);

        List<Seller> followsAtualizados = c1.getFollows();

        followsAtualizados.add(s1);

        c1.setFollows(followsAtualizados);

        c_service.updateCustomer(c1);

        return HttpStatus.OK;
    }


}
