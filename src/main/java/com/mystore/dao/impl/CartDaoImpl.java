package com.mystore.dao.impl;

import com.mystore.dao.CartDao;
import com.mystore.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class CartDaoImpl implements CartDao {
    private Map<String, Cart> listOfCarts;

    public CartDaoImpl() {
        listOfCarts = new HashMap<String, Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())) {
            throw new IllegalArgumentException(String.format("Can not create a cart.A cart with the given id(%)" + "already" + "exist", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(String cartId, Cart cart) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not Update cart.The cart with the given id(%)" + "doesn't" + "exist", cart.getCartId()));
        }
        listOfCarts.put(cart.getCartId(), cart);

    }

    @Override
    public void delete(String cartId) {
        if (!listOfCarts.keySet().contains(cartId)) {
            throw new IllegalArgumentException(String.format("Can not delete cart.The cart with the given id(%)" + "doesn't" + "exist", cartId));
        }
        listOfCarts.remove(cartId);
    }
}