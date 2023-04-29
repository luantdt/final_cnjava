package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.*;
import com.finalProject.foodStore.repositories.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderFoodRepository orderFoodRepository;

    @Autowired
    private OrderUnitRepository orderUnitRepository;

    public void payAllItem(){

        OrderFood orderFood = new OrderFood();

        //User user =userRepository.findByEmail();

        List<Cart> cart = cartRepository.findAllByUID(252);
        List<Food> checkoutDetail = new ArrayList<Food>();
        int total = 0;

        if(cart.size() > 0){
            for (Cart c : cart) {
                Food pro = productRepository.findById(c.getFoodId()).get();
                total += pro.getPrice();
                checkoutDetail.add(pro);
            }
        }

        orderFood.setTotal(total);
//        orderFood.setUser();
        orderFoodRepository.save(orderFood);
        orderFoodRepository.flush();
        for(Food food : checkoutDetail){
            OrderUnit orderUnit = new OrderUnit();
            orderUnit.setFoodId(food.getId());
            orderUnit.setOrderId(orderFood.getId());
            orderUnit.setQuatity(1);
            orderUnit.setUnitPrice((int) food.getPrice());
            orderUnitRepository.save(orderUnit);
        }

        cartRepository.deleteAllByUID(252);
    }


    public void getAllAndModel(Model model) {
        //User user = userRepository.findByEmail(checkAuth.getAuthName());
        List<OrderFood> orderFood = orderFoodRepository.findAllByUID(252);
        List<OrderUnit> orderUnit = new ArrayList<OrderUnit>();
        List<String> proName = new ArrayList<String>();
        for (OrderFood orderDetail2 : orderFood) {
            List<OrderUnit> unit = orderUnitRepository.findAllByOID(orderDetail2.getId());
            orderUnit.addAll(unit);
            for (OrderUnit u : unit) {
                String name = productRepository.findById(u.getId()).get().getName();
                proName.add(name);
            }
        }
        model.addAttribute("proName", proName);
        model.addAttribute("orderFood", orderFood);
        model.addAttribute("orderUnit", orderUnit);
    }

}
