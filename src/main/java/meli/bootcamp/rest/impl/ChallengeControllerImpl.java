package meli.bootcamp.rest.impl;

import meli.bootcamp.data.ProductRepository;
import meli.bootcamp.data.PublicationRepository;
import meli.bootcamp.entity.Customer;
import meli.bootcamp.entity.Product;
import meli.bootcamp.entity.Publication;
import meli.bootcamp.entity.Seller;
import meli.bootcamp.rest.dto.*;
import meli.bootcamp.service.CustomerService;
import meli.bootcamp.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import meli.bootcamp.rest.ChallengeController;
import meli.bootcamp.rest.SellerDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/challenge")
public class ChallengeControllerImpl implements ChallengeController {

    CustomerService c_service;
    SellerService s_service;
    ProductRepository productRepository;
    PublicationRepository publicationRepository;

    Logger logger = LoggerFactory.getLogger(ChallengeControllerImpl.class);

    public ChallengeControllerImpl(CustomerService c_service, SellerService s_service, ProductRepository productRepository, PublicationRepository publicationRepository) {
        this.c_service = c_service;
        this.s_service = s_service;
        this.productRepository = productRepository;
        this.publicationRepository = publicationRepository;
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
    public List<CustomerDTO> listAllFollowers(@PathVariable Integer userId, @RequestParam(required = false) String order){
        List<CustomerDTO> customers = new ArrayList<>();
        Seller s1 = s_service.getSellerById(userId);

        for(Customer c1 : s1.getFollowers()){
            CustomerDTO dto = new CustomerDTO();
            dto.setId(c1.getId());
            dto.setNome(c1.getNome());
            customers.add(dto);
        }

        if(order != null && order.toLowerCase(Locale.ROOT).equals("asc")){
            Collections.sort(customers);
        } else if(order != null && order.toLowerCase(Locale.ROOT).equals("desc")){
            Collections.sort(customers, Collections.reverseOrder());
        }

        return customers;
    }

    @GetMapping("/users/{userId}/followed/list")
    public List<SellerDTO> listAllSellers(@PathVariable Integer userId, @RequestParam(required = false) String order){
        List<SellerDTO> sellers = new ArrayList<>();
        Customer customer = c_service.getCustomerById(userId);

        for(Seller seller : customer.getFollows()){
            SellerDTO dto = new SellerDTO();
            dto.setId(seller.getId());
            dto.setNome(seller.getNome());
            sellers.add(dto);
        }

        if(order != null && order.toLowerCase(Locale.ROOT).equals("asc")){
            Collections.sort(sellers);
        } else if(order != null && order.toLowerCase(Locale.ROOT).equals("desc")){
            Collections.sort(sellers, Collections.reverseOrder());
        }
        return sellers;
    }

    @PostMapping("/products/newpost")
    public HttpStatus createNewPublication(@RequestBody PublicationRequestDTO publicationRequest) {

        Publication publication = new Publication();
        Integer sellerId = publicationRequest.getUserId();
        Product product = new Product();

        product.setName(publicationRequest.getDetail().getProductName());
        product.setType(publicationRequest.getDetail().getType());
        product.setBrand(publicationRequest.getDetail().getBrand());
        product.setColor(publicationRequest.getDetail().getColor());
        product.setNotes(publicationRequest.getDetail().getNotes());

        publication.setDate(LocalDate.parse(publicationRequest.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy") ));
        publication.setProduct(product);
        publication.setCategory(publicationRequest.getCategory());
        publication.setPrice(publicationRequest.getPrice());
        publication.setHasPromo(false);
        publication.setDiscount(0.0);


        Seller s1 = s_service.getSellerById(sellerId);
        List<Publication> publications = s1.getPublications();
        List<Product> products  = s1.getProducts();
        products.add(product);
        publications.add(publication);
        s1.setPublications(publications);
        s1.setProducts(products);
        s_service.updateSeller(s1);

        return HttpStatus.OK;
    }

    @GetMapping("/products/followed/{userId}/list")
    public List<Publication> listPublicationsByIdAndDate(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        List<Publication> publications = new ArrayList<>();
        List<Integer> followedSellers = new ArrayList<>();
        Customer customer = c_service.getCustomerById(userId);
        customer.getFollows().forEach(follows-> followedSellers.add(follows.getId()));
        for(Integer id: followedSellers){
            publicationRepository.findAll().forEach(publication -> {
                if(publication.getSeller_id() == id && publication.getDate().isAfter(LocalDate.now().minusDays(14))){
                    publications.add(publication);
                }
            });
        }

        for(Publication p : publications){
            System.out.println(p.toString());
        }

        if(order.toLowerCase(Locale.ROOT).equals("date_desc")){
            Collections.sort(publications);
        } else if(order.toLowerCase(Locale.ROOT).equals("date_asc")){
            Collections.sort(publications, Collections.reverseOrder());
        }


        return publications;
    }

    @PostMapping("/users/{customerId}/unfollow/{sellerId}")
    public HttpStatus unfollowSeller(@PathVariable Integer customerId, @PathVariable Integer sellerId) {
        Customer customer = c_service.getCustomerById(customerId);
        List<Seller> follows = customer.getFollows();
        List<Seller> followsUpdated = new ArrayList<>();
        follows.forEach(seller -> {
            if(seller.getId() != sellerId){
                followsUpdated.add(seller);
            }
        });

        customer.setFollows(followsUpdated);
        c_service.updateCustomer(customer);

        return HttpStatus.OK;
    }

    @PostMapping("/products/newpromopost")
    public HttpStatus createNewPromoPost(@RequestBody PromoPublicationRequestDTO promoPublication) {
        Publication publication = new Publication();
        Integer sellerId = promoPublication.getUserId();
        Product product = new Product();

        product.setName(promoPublication.getDetail().getProductName());
        product.setType(promoPublication.getDetail().getType());
        product.setBrand(promoPublication.getDetail().getBrand());
        product.setColor(promoPublication.getDetail().getColor());
        product.setNotes(promoPublication.getDetail().getNotes());

        publication.setDate(LocalDate.parse(promoPublication.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy") ));
        publication.setProduct(product);
        publication.setCategory(promoPublication.getCategory());
        publication.setPrice(promoPublication.getPrice());
        publication.setHasPromo(true);
        publication.setDiscount(promoPublication.getDiscount());

        Seller s1 = s_service.getSellerById(sellerId);
        List<Publication> publications = s1.getPublications();
        List<Product> products  = s1.getProducts();
        products.add(product);
        publications.add(publication);
        s1.setPublications(publications);
        s1.setProducts(products);
        s_service.updateSeller(s1);

        return HttpStatus.OK;
    }

    @GetMapping("/products/{userId}/countPromo")
    public PromoPostsCountDTO getCountOfPromoPostsBySeller(@PathVariable Integer userId) {
        PromoPostsCountDTO dto = new PromoPostsCountDTO();
        int count = 0;
        List<Publication> publications = new ArrayList<>();
        for(Publication p : publicationRepository.findAll()){
            if (p.getSeller_id() == userId && p.getHasPromo() == true){
                ++count;
            }
        }

        dto.setPromoproducts_count(count);
        Seller s1 = s_service.getSellerById(userId);
        dto.setUserName(s1.getNome());
        dto.setUserId(userId);

        return dto;
    }

    @GetMapping("/products/{userId}/list/")
    public PromoPostsByUserDTO getPromoPostsByUserDTO(@PathVariable Integer userId) {
        PromoPostsByUserDTO dto = new PromoPostsByUserDTO();
        List<Publication> publications = new ArrayList<>();
        publicationRepository.findAll().forEach(publication -> {
            if(publication.getSeller_id() == userId && publication.getHasPromo() == true){
                publications.add(publication);
            }
        });

        Seller s1 = s_service.getSellerById(userId);
        dto.setUserId(userId);
        dto.setUserName(s1.getNome());
        dto.setPosts(publications);

        return dto;
    }
}
