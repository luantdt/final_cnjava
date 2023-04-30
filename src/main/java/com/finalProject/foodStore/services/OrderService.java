package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.*;
import com.finalProject.foodStore.repositories.*;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderFoodRepository orderFoodRepository;

	@Autowired
	private OrderUnitRepository orderUnitRepository;

	@Autowired
	private AuthenticationService authenticationService;

	public void payAllItem(HttpServletRequest httpServletRequest) {

		OrderFood orderFood = new OrderFood();

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

		orderFood.setTotal(total);
		orderFood.setUser(user);
		orderFoodRepository.save(orderFood);
		orderFoodRepository.flush();
		for (Food food : checkoutDetail) {
			OrderUnit orderUnit = new OrderUnit();
			orderUnit.setFoodId(food.getId());
			orderUnit.setOrderId(orderFood.getId());
			orderUnit.setQuatity(1);
			orderUnit.setUnitPrice((int) food.getPrice());
			orderUnitRepository.save(orderUnit);
		}

		cartRepository.deleteAllByUID(user.getId());
	}

	public void getAllAndModel(Model model, HttpServletRequest httpServletRequest) {

		User user = authenticationService.AuthInfor(httpServletRequest);
		List<OrderFood> orderFood = orderFoodRepository.findAllByUser(user);
		
		List<OrderUnit> orderUnit = new ArrayList<>();
		List<String> productName = new ArrayList<String>();
		for (OrderFood orderFood1 : orderFood) {
			List<OrderUnit> unit = orderUnitRepository.findAllByOID(orderFood1.getId());
			orderUnit.addAll(unit);
			for (OrderUnit u : unit) {
				String name = productRepository.findById(u.getId()).get().getName();
				productName.add(name);
			}
		}
		model.addAttribute("proName", productName);
		model.addAttribute("orderFood", orderFood);
		model.addAttribute("orderUnit", orderUnit);

	}

}
