package com.finalProject.foodStore.repositories;

import com.finalProject.foodStore.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository  extends JpaRepository<Cart, Integer> {

    @Query("SELECT c from cart c where c.userId = :UID")
    List<Cart> findAllByUID(@Param("UID") int UID);

    @Modifying
    @Transactional
    @Query("DELETE FROM cart c WHERE c.userId = :UID")
    void deleteAllByUID(@Param("UID") int UID);

    @Query(value = "DELETE FROM cart c WHERE c.foodId = ?1", nativeQuery = true)
    void deleteItemById(Integer foodId);


}
