package com.finalProject.foodStore.repositories;

import com.finalProject.foodStore.models.OrderUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderUnitRepository extends JpaRepository<OrderUnit, Integer> {

    @Query("SELECT ou FROM orderunit ou WHERE ou.orderId = :OID")
    List<OrderUnit> findAllByOID(@Param("OID")int OID);
}
