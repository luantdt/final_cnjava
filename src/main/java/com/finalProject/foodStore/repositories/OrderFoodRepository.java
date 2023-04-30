package com.finalProject.foodStore.repositories;

import com.finalProject.foodStore.models.OrderFood;
import com.finalProject.foodStore.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderFoodRepository extends JpaRepository<OrderFood, Integer> {

    @Query("SELECT o from orderfood o where o.user = :UID")
    List<OrderFood> findAllByUID(@Param("UID") int UID);
    
    List<OrderFood> findAllByUser(User user);
}
