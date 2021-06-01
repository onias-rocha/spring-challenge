package meli.bootcamp.rest;

import meli.bootcamp.entity.Customer;
import meli.bootcamp.entity.Seller;
import meli.bootcamp.service.CustomerService;
import meli.bootcamp.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/users/{userId}/followers/count/")
    public FollowersCountDTO getAmmountOfFollowers(@PathVariable Integer userId){
        FollowersCountDTO dto = new FollowersCountDTO();
        Seller s1 = s_service.getSellerById(userId);
        dto.setFollowersCount(s1.getFollowers().size());
        dto.setUserId(userId);
        dto.setUserName(s1.getNome());
        return dto;
    }

    @GetMapping("/users/{userId}/followers/list")
    public List<CustomerDTO> listAllFollowers(@PathVariable Integer userId){

        List<CustomerDTO> customers = new ArrayList<>();

        Seller s1 = s_service.getSellerById(userId);


        for(Customer c1 : s1.getFollowers()){
            CustomerDTO dto = new CustomerDTO();
            dto.setId(c1.getId());
            dto.setNome(c1.getNome());
            customers.add(dto);
        }
        return customers;
    }

    @GetMapping("/users/{userId}/followed/list")
    public List<SellerDTO> listAllSellers(@PathVariable Integer userId){
        List<SellerDTO> sellers = new ArrayList<>();
        Customer customer = c_service.getCustomerById(userId);
        for(Seller seller : customer.getFollows()){
            SellerDTO dto = new SellerDTO();
            dto.setId(seller.getId());
            dto.setNome(seller.getNome());
            sellers.add(dto);
        }
        return sellers;
    }


}
