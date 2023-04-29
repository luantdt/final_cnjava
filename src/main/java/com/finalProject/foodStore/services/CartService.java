package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.Cart;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.models.User;
import com.finalProject.foodStore.repositories.CartRepository;
import com.finalProject.foodStore.repositories.ProductRepository;
import com.finalProject.foodStore.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    private AuthenticationService authenticationService;
    List<Food> checkoutDetail = new ArrayList<Food>();

    public void getModel(Model model, HttpServletRequest httpServletRequest) {

        // User user = userRepository.findByEmail(checkAuth.getAuthName());
        User user = authenticationService.AuthInfor(httpServletRequest);

        List<Cart> cart = cartRepository.findAllByUID(user.getId());
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

    public void addCart(int id, HttpServletRequest httpServletRequest) {
        //User user = userRepository.findByEmail(checkAuth.getAuthName());
        Cart newCart = new Cart();
        User user = authenticationService.AuthInfor(httpServletRequest);

        newCart.setFoodId(id);
        newCart.setUserId(user.getId());
        newCart.setQuantity(1);
        cartRepository.save(newCart);






    }

    public void deleteById(Integer id) {
        //User user = userRepository.findByEmail(checkAuth.getAuthName());
        cartRepository.deleteItemById(id);
    }
}
