package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.Cart;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.models.User;
import com.finalProject.foodStore.repositories.CartRepository;
import com.finalProject.foodStore.repositories.ProductRepository;
import com.finalProject.foodStore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    List<Food> checkoutDetail = new ArrayList<Food>();
    public void getModel(Model model) {

        // User user = userRepository.findByEmail(checkAuth.getAuthName());
        List<Cart> cart = cartRepository.findAllByUID(252);
        List<Food> checkoutDetail = new ArrayList<Food>();
        int total = 0;
        if (cart.size() > 0) {
            for (Cart c : cart) {
                Food pro = productRepository.findById(c.getFoodId()).get();
                total += pro.getPrice();
                checkoutDetail.add(pro);
            }
        }

        model.addAttribute("checkoutDetail", checkoutDetail);
        model.addAttribute("total", total);
        model.addAttribute("numberItem", cart.size());
    }

    public void addCart(int id) {
        //User user = userRepository.findByEmail(checkAuth.getAuthName());
        Cart newCart = new Cart();

        newCart.setFoodId(id);
        newCart.setUserId(252);
        newCart.setQuantity(1);
        cartRepository.save(newCart);

        newCart.setQuantity(newCart.getQuantity()+1);




    }

    public void deleteById(Integer id) {
        //User user = userRepository.findByEmail(checkAuth.getAuthName());
        cartRepository.deleteItemById(id);
    }
}
