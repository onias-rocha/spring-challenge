package meli.bootcamp.rest;

import meli.bootcamp.entity.Seller;
import meli.bootcamp.service.SellerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellerControllerImpl implements SellerController {

    SellerService service;

    public SellerControllerImpl(SellerService service) {
        this.service = service;
    }

    @Override
    public void createSeller(Seller seller) {

    }

    @Override
    public Seller getSellerById(Integer id) {
        return null;
    }

    @Override
    @GetMapping("/api/seller")
    public List<Seller> getAllSellers() {
        return service.getAllSellers();
    }

    @Override
    public Seller updateSeller(Integer id) {
        return null;
    }

    @Override
    public void deleteSeller(Integer id) {

    }
}
