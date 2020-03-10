package com.example.simpleinv.repositories.Customer;

import com.example.simpleinv.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositories extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.custId = ?1")
    Customer findDetailId(Integer id);
}
