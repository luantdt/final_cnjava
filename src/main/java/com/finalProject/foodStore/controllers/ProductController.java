package com.finalProject.foodStore.controllers;

import com.finalProject.foodStore.dto.CategoryDto;
import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.models.News;
import com.finalProject.foodStore.models.User;
import com.finalProject.foodStore.services.AuthenticationService;
import com.finalProject.foodStore.services.CategoryService;
import com.finalProject.foodStore.services.NewsService;
import com.finalProject.foodStore.services.ProductService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NewsService newsService;
    
    @Autowired
    private AuthenticationService authService;

    @GetMapping("/")
    public String getHome(Model model, HttpServletRequest req){
        List<Category> categories = categoryService.getAllCategories();
        List<Food> products = productService.getAllProducts();
        List<Food> limitProducts = productService.getLimitProducts();
        List<News> news = newsService.getAllBlog();
        model.addAttribute("title", "Home");
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("limitProducts",limitProducts);
        model.addAttribute("news",news);
        User user = authService.AuthInfor(req);
        if (user == null) {
        	 model.addAttribute("auth", false);
        } else {
        	model.addAttribute("auth", true);
        }
        
        return "client/index";
    }
    
    @GetMapping("/news")
    public String getNews(Model model)
    {
    	List<News> news = newsService.getAllBlog();
    	model.addAttribute("news",news);
        return "client/news";
    }
	@RequestMapping("/single-news/{id}")
	public String sigleNew(@PathVariable("id") int id, Model model) {
		News a = newsService.getBlogById(id);
		model.addAttribute("news", a);
		return "client/single-news";
	}
    @GetMapping("/contact")
    public String getContact(){
        return "client/contact";
    }

    @GetMapping("/product")
    public String getProduct(Model model)
    {
        List<Category> categories = categoryService.getAllCategories();
        List<Food> products = productService.getAllProducts();
        model.addAttribute("categories", categories);
        model.addAttribute("title", "Manage Product");
        model.addAttribute("products", products);
        return "client/shop";
    }

    @GetMapping("/product/{pageNo}")
    public String productsPage(@PathVariable("pageNo") int pageNo, Model model){
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        Page<Food> products = productService.pageProducts(pageNo);
        model.addAttribute("categories", categoryDtoList);
        model.addAttribute("title", "Manage Product");
        model.addAttribute("size", products.getSize());
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("products", products);
        return "client/shop";
    }

    @GetMapping("search-result/{pageNo}")
    public String searchProducts(@PathVariable("pageNo") int pageNo,@RequestParam("keyword") String keyword, Model model){

        Page<Food> products = productService.searchProducts(pageNo, keyword);
        model.addAttribute("title", "Search Result");
        model.addAttribute("products", products);
        model.addAttribute("size", products.getSize());
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("currentPage", pageNo);


        return "client/result-products";
    }



    @GetMapping("/find-product/{id}")
    public String findProductById(@PathVariable("id") Integer id, Model model){
        Optional<Food> food	 = productService.getProductById(id);
        Integer categoryId = food.get().getCategory().getId();
        List<Food> foods = productService.getRelatedProducts(categoryId);
        model.addAttribute("title", "Manage Product");
        model.addAttribute("product", food.get());
        model.addAttribute("products", foods);
        return "client/product-detail";
    }

    @GetMapping("/products-in-category/{id}")
    public String getProductsInCategory(@PathVariable("id") Integer categoryId, Model model){
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        Category category = categoryService.findById(categoryId).get();
        List<Food> products = productService.getProductsInCategory(categoryId);
        model.addAttribute("categories", categoryDtoList);
        model.addAttribute("category", category);
        model.addAttribute("products", products);


        return "client/products-in-category";
    }


}
