package com.anasdev.billingservice.feign;

import com.anasdev.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")//open feign contacte discovery service lui donne le nom du microservice et recupere l'adresse du microservice
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);//pathvariable bach id ytkhad nichan valeur dyalo otsjl f id

    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();
}
