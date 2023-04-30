package com.finalProject.foodStore.controllers.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finalProject.foodStore.models.Cart;
import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.models.ResponseObject;
import com.finalProject.foodStore.repositories.CartRepository;
import com.finalProject.foodStore.repositories.ProductRepository;
import com.finalProject.foodStore.services.CategoryService;
import com.finalProject.foodStore.services.ImageStorageService;
import com.finalProject.foodStore.services.ProductService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("admin/food")
public class FoodManagementController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService cateService;

	@Autowired
	private ImageStorageService imgStorageService;

	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private	CartRepository cartRepo;
	
	/*
	 * @Autowired private OrderUnitRepository orderUnitRepo
	 */

	@GetMapping("")
	public String getFoodManagement(Model model) {
		model.addAttribute("foods", productService.findAll());
		return "admin/foodManagement";
	}

	@PostMapping("/update")
	public ResponseEntity<ResponseObject> updateFood(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "categoryName", required = false) String cateName,
			@ModelAttribute @Valid Food newFood) {

		Optional<Food> food = productService.getProductById(newFood.getId());

		if (!food.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponseObject("FALSE", "Could not found", null));
		}
		Category cate = new Category();
		Food oldFood = food.get();
		if (cateName != null) {
			cate = cateService.findByCateName(cateName);
			if (cate == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ResponseObject("FALSE", "Category is not valid", null));
			}

			oldFood.setCategory(cate);
		}

		try {
			if (file != null) {
				imgStorageService.deleteFile(oldFood.getImage());
				String generatedFileName = imgStorageService.storeFile(file);
				oldFood.setImage(generatedFileName);
			}
			oldFood.setName(newFood.getName());
			oldFood.setDescription(newFood.getDescription());
			oldFood.setQuantity(newFood.getQuantity());
			oldFood.setPrice(newFood.getPrice());
			oldFood.setStatus(newFood.isStatus());

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("OK", "Update food has successfull", productRepo.save(oldFood)));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("FALSE", e.toString(), null));
		}
	}

	@GetMapping("/{id}")
	public String getEditFoodPage(Model model, @PathVariable int id) {
		model.addAttribute("food", productService.getProductById(id).get());
		model.addAttribute("cates", cateService.getAllCategories());

		return "admin/editFood";
	}

	@GetMapping("/add")
	public String getAddFoodPage(Model model) {
		model.addAttribute("cates", cateService.getAllCategories());
		return "/admin/addFood";
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseObject> addFood(@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "categoryName", required = false) String cateName,
			@ModelAttribute @Valid Food newFood) {

		Food food = new Food();

		Category cate = new Category();

		if (cateName != null) {
			cate = cateService.findByCateName(cateName);
			if (cate == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ResponseObject("FALSE", "Category is not valid", null));
			}

			food.setCategory(cate);
		}

		try {

			String generatedFileName = imgStorageService.storeFile(file);
			food.setImage(generatedFileName);
			
			food.setName(newFood.getName());
			food.setDescription(newFood.getDescription());
			food.setQuantity(newFood.getQuantity());
			food.setPrice(newFood.getPrice());
			food.setStatus(newFood.isStatus());

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("OK", "Add food has successfull", productRepo.save(food)));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("FALSE", e.toString(), null));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseObject> deleteFood(@PathVariable int id) {
		Optional<Food> food = productService.getProductById(id);
		
		if (!food.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("FALSE","Could not found", null));
		}
		
		List<Cart> cart = cartRepo.findAllByUID(id);
		if (cart.size() > 0) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ResponseObject("FALSE","The data cannot be deleted because the data is being used by the cart object and the order product", null));
		}
		
		productRepo.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK","Delete food has successful", null));
	}
}
