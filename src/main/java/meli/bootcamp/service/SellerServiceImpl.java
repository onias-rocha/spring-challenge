package meli.bootcamp.service;

import meli.bootcamp.data.SellerRepository;
import meli.bootcamp.entity.Seller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    SellerRepository repository;

    public SellerServiceImpl(SellerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createSeller(Seller seller) {

    }

    @Override
    public Seller getSellerById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Seller> getAllSellers() {
        List<Seller> sellers = new ArrayList<>();
        Iterable<Seller> allSellers= repository.findAll();
        for(Seller seller:allSellers){
            sellers.add(seller);
        }
        return sellers;
    }

    @Override
    public Seller updateSeller(Integer id) {
        return null;
    }

    @Override
    public void deleteSeller(Integer id) {

    }
}
