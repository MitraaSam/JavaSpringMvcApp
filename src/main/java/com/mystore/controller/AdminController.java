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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Controller
public class AdminController {
    private Path path;

    private final ProductDao productDao;
    public AdminController(ProductDao productDao) {
        this.productDao = productDao;
    }
    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";

    }
    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products=productDao.getAllProduct();
        model.addAttribute("products",products);
        return "productInventory";
    }
    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product=new Product();
        product.setProductCondition("instruments");
        model.addAttribute("product",product);
        return "addProduct";
    }
    @RequestMapping(value ="/admin/productInventory/addProduct",method= RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){

        if (result.hasErrors()){
            return "addProduct";
        }
        productDao.addProduct(product);
        MultipartFile productImage =product.getProductImage();
        String rootDirectory =request.getSession().getServletContext().getRealPath("/");
        path= Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
        if(productImage !=null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            }
            catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product Image Saving failed",e);
            }
        }
        return "redirect:/admin/productInventory";
    }
    @RequestMapping(value ="/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model){
        productDao.deleteProduct(id);
        return "redirect:/admin/productInventory";
    }
    @RequestMapping("/admin/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable ("id")int id,Model model){
        Product product=productDao.getProductById(id);
        model.addAttribute(product);
        return "editProduct";
    }
    @RequestMapping(value ="/admin/productInventory/editProduct",method= RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") Product product, BindingResult result,Model model, HttpServletRequest request){
        if (result.hasErrors()){
            return "editProduct";
        }
        MultipartFile productImage =product.getProductImage();
        String rootDirectory =request.getSession().getServletContext().getRealPath("/");
        path= Paths.get(rootDirectory+"\\WEB-INF\\resources\\images\\"+product.getProductId()+".png");
        if(productImage !=null && !productImage.isEmpty()){
            try {
                productImage.transferTo(new File(path.toString()));
            }
            catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product Image Saving failed",e);
            }
        }
        productDao.editProduct(product);
        return "redirect:/admin/productInventory";
    }
}
