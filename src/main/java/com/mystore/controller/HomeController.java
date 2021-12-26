package com.mystore.controller;

import com.mystore.dao.ProductDao;
import com.mystore.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {

    private final ProductDao productDao;
    public HomeController(ProductDao productDao) {
        this.productDao = productDao;
    }
    @RequestMapping("/")
    public String home(){

        return "home";
    }
    @RequestMapping("/productList")
    public String geProducts(Model model){
        List<Product> products=productDao.getAllProduct();
        //Product product=productList.get(0);
        model.addAttribute("products",products);
        return "productList";

    }
    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product =productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }

}
