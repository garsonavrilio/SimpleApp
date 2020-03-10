package com.example.simpleinv.repositories.Checkout;

import com.example.simpleinv.dto.CheckoutDTO.CheckoutResponseDTO;
import com.example.simpleinv.model.Checkout;
import com.example.simpleinv.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@Modifying
@Transactional
@Repository
public interface CheckoutRepositories extends CrudRepository<Checkout, Integer> {

    @Query("SELECT SUM (c.checkoutTotal) FROM Checkout c WHERE c.checkoutCustId = ?1")
    Integer grandTotalCheckout(Integer id);

    @Query("SELECT c FROM Checkout c WHERE c.checkoutCustId = ?1")
    List<Checkout> getAllCheckoutById(Integer Id);

    @Modifying
    @Query(value = "DELETE FROM Checkout c WHERE c.checkoutCustId =:id")
    void deleteCheckoutById(@Param("id") Integer Id);

    @Query("SELECT c FROM Checkout c WHERE c.checkoutCustId = ?1")
    List<Checkout> findCheckoutbyCustId (Integer id);
}
