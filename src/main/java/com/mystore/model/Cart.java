package com.mystore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private  String cartId;
    private Map <Integer,CartItem> cartItems;
    private double grandTotal;

    private Cart(){
        cartItems= new HashMap<Integer,CartItem>();
        grandTotal=0;

    }
    public Cart(String cartId){
        this();
        this.cartId=cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    public void addCartItem(CartItem item){
        int productId=item.getProduct().getProductId();
        if(cartItems.containsKey(productId)){
            CartItem exsidtingCartItem=cartItems.get(productId);
            exsidtingCartItem.setQuantity(exsidtingCartItem.getQuantity()+item.getQuantity());
            cartItems.put(productId,exsidtingCartItem);

        }else {
            cartItems.put(productId,item);
        }
        updateGrandTotal();
    }
    public void removeCartItem(CartItem item){
        int productId=item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }
    public void updateGrandTotal(){
        grandTotal=0;
        for(CartItem item:cartItems.values()){
            grandTotal=grandTotal+item.getTotalPrice();
        }
    }
}
