package com.mystore.controller;

import com.mystore.dao.CartDao;
import com.mystore.dao.ProductDao;
import com.mystore.model.Cart;
import com.mystore.model.CartItem;
import com.mystore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
    private final CartDao cartDao;
    private final ProductDao productDao;

    public CartController(ProductDao productDao, CartDao cartDao) {
        this.productDao = productDao;
        this.cartDao = cartDao;
    }

    @RequestMapping (value = "/{cartId}",method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable (value = "cartId") String cartId){
        return cartDao.read(cartId);
    }
    @RequestMapping (value = "/{cartId}",method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void  update(@PathVariable(value = "cartId") String cartId,@RequestBody  Cart cart){
         cartDao.update(cartId,cart);
    }
    @RequestMapping(value = "/{cartId}",method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId){
         cartDao.delete(cartId);

    }
    @RequestMapping(value = "/add/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable (value = "productId") Integer productId, HttpServletRequest request){
        String sessionId=request.getSession(true).getId();
        Cart cart=cartDao.read(sessionId);
        if (cart == null){
            cart=cartDao.create(new Cart(sessionId));
        }
        Product product=productDao.getProductById(productId);
        if (product==null) {

            throw new IllegalArgumentException(new Exception());
            }
        cart.addCartItem(new CartItem(product));
        cartDao.update(sessionId,cart);
    }
    @RequestMapping(value = "/remove/{productId}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable (value = "productId") Integer productId, HttpServletRequest request){
        String sessionId=request.getSession(true).getId();
        Cart cart=cartDao.read(sessionId);
        if (cart == null){
            cart=cartDao.create(new Cart(sessionId));
        }
        Product product=productDao.getProductById(productId);
        if (product==null) {

            throw new IllegalArgumentException(new Exception());
        }
        cart.removeCartItem(new CartItem(product));
        cartDao.update(sessionId,cart);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST ,reason = "an Illegal error occured")
    public void handelClientError(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR ,reason = "Internall Server Error")
    public void handelServerError(Exception e){}
}
