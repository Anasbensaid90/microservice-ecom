package com.anasdev.billingservice.web;

import com.anasdev.billingservice.entities.Bill;
import com.anasdev.billingservice.entities.ProductItem;
import com.anasdev.billingservice.feign.CustomerRestClient;
import com.anasdev.billingservice.feign.ProductRestClient;
import com.anasdev.billingservice.repository.BillRepository;
import com.anasdev.billingservice.repository.ProductItemRepository;
import com.netflix.discovery.converters.Auto;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;
    @GetMapping(path="/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItemList().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;

    }
}
