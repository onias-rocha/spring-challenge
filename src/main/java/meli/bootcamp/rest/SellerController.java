package meli.bootcamp.rest;

import meli.bootcamp.entity.Seller;

import java.util.List;

public interface SellerController {

    public void createSeller(Seller seller);

    public Seller getSellerById(Integer id);

    public List<Seller> getAllSellers();

    public Seller updateSeller (Integer id);

    public void deleteSeller (Integer id);
}
