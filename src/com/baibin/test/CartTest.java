package com.baibin.test;

import com.baibin.pojo.Cart;
import com.baibin.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author: Baibin
 * @Date: 2022/5/7 11:30
 * @Description: TODO
 */
public class CartTest {
    @Test
        public void addItem() throws Exception {
//      List<CartItem> list = new ArrayList<>();
//      list.add(new CartItem(1,"aa",10,new BigDecimal(100),new BigDecimal(1000)));
//      list.add(new CartItem(2,"bb",20,new BigDecimal(200),new BigDecimal(4000)));
//      list.add(new CartItem(3,"cc",30,new BigDecimal(100),new BigDecimal(3000)));
//        Cart cart = new Cart(60,new BigDecimal(8000),list);
//      cart.addItem(new CartItem(1,"bb",1,new BigDecimal(100),new BigDecimal(1000)));
//        System.out.println(list);

        Cart cart= new Cart();

        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(3,"ccb",1,new BigDecimal(50),new BigDecimal(150)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() throws Exception {


        Cart cart= new Cart();

        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(3,"ccb",1,new BigDecimal(50),new BigDecimal(150)));
        System.out.println(cart);
        cart.deleteItem(2);
        System.out.println(cart);



    }

    @Test
    public void clear() throws Exception {

        Cart cart= new Cart();

        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(3,"ccb",1,new BigDecimal(50),new BigDecimal(150)));
        System.out.println(cart);
//        cart.deleteItem(2);
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() throws Exception {
        Cart cart= new Cart();

        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(1,"aa",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(2,"bb",1,new BigDecimal(50),new BigDecimal(50)));
        cart.addItem(new CartItem(3,"ccb",1,new BigDecimal(50),new BigDecimal(150)));
        System.out.println(cart);
//        cart.deleteItem(2);
        cart.updateCount(2,1);
        System.out.println(cart);
    }

}