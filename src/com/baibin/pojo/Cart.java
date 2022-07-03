package com.baibin.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Baibin
 * @Date: 2022/5/7 9:45
 * @Description: TODO
 */
public class Cart {
    //    private Integer totalCount;//商品总数量
//    private BigDecimal totalPrice;//商品总价格
//    private List<CartItem> cartItems;//购物车商品
    private Map<Integer, CartItem> Items = new LinkedHashMap<>();

    //添加商品
    public void addItem(CartItem cartItem) {
//        list集合的方法
//        for (CartItem item : cartItems) {
//            if (cartItem.getId()==item.getId()){
//                item.setCount((item.getCount()+1));
//                item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
//        }else{
//            cartItems.add(cartItem);
//    }
//    }
        CartItem item = Items.get(cartItem.getId());
        if (item != null) {
            //已经存在此商品
            item.setCount(item.getCount() + 1);//更新数量
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新总金额
        } else {
            //未添加
            Items.put(cartItem.getId(), cartItem);
        }
    }

    //删除商品
    public void deleteItem(Integer id) {
        Items.remove(id);
    }

    //清空购物车
    public void clear() {
        Items.clear();
    }

    //修改商品数量
    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = Items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));//更新总金额
        }
    }


    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (CartItem cartItem : Items.values()) {
            totalCount+=cartItem.getCount();
        }
        return totalCount;
    }
//总数量和总金额是通过累加得到的并不能赋值得到
//    public void setTotalCount(Integer totalCount) {
//        this.totalCount = totalCount;
//    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem cartItem : Items.values()) {
            totalPrice=totalPrice.add(cartItem.getTotalPrice());
        }
        return totalPrice;
    }
//总数量和总金额是通过累加得到的并不能赋值得到
//    public void setTotalPrice(BigDecimal totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", Items=" + Items +
                '}';
    }

    public Map<Integer, CartItem> getItems() {
        return Items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        Items = items;
    }


    public Cart() {
    }
}
