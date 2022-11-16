package com.llkj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Array;
import java.util.*;

/**
 * @ClassName Cart
 * @Description TODO
 * @Author qing
 * @Date 2022/11/15 9:24
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    //购物车总金额
    private Double totalAmount = 0d;
    //购物车总数量
    private Integer totalCount = 0;
    //春初商品详情信息的集合key表示书记的id值，value表示CartItem类
    private Map<Integer, CartItem> cartItemMap = new HashMap();
    public void clearAllCartItem(){
        cartItemMap=new HashMap();
    }

    //删除对应得商品
    public CartItem deleteCartItem(Integer id){
        CartItem cartItem = cartItemMap.remove(id);
        return cartItem;
    }
    //自定义方法：添加购物车详情的方法
    public void addBookToCartItem(Books book) {
        if (cartItemMap.containsKey(book.getId())) {//表示该书购买过
            CartItem cartItem = cartItemMap.get(book.getId());
            Integer total = cartItem.getTotal();
            cartItem.setTotal(total + 1);
        } else {//表示第一次购买产品
            CartItem cartItem = new CartItem();
            cartItem.setBookId(book.getId());
            cartItem.setBookName(book.getTitle());
            cartItem.setImgPath(book.getImgPath());
            cartItem.setPrice(book.getPrice());
            cartItem.setTotal(1);
            cartItemMap.put(book.getId(), cartItem);
        }
    }

    //讲购物车中的map类型转换到list类型
    public List<CartItem> getCartItemList() {
        ArrayList<CartItem> arrayList = new ArrayList<>();
        Collection<CartItem> values = cartItemMap.values();
        values.stream().forEach(a -> arrayList.add(a));
        return arrayList;
    }

    //加号功能
    //获取总数量
    public Integer getTotalCount() {
        this.totalCount = 0;
        Collection<CartItem> values = cartItemMap.values();
        values.forEach(cartItem -> {
            //遍历每一个cartItem中的数量
            this.totalCount += cartItem.getTotal();
        });
        return totalCount;
    }

    public Double getTotalAmount() {
        this.totalAmount = 0d;
        List<CartItem> cartItemList = getCartItemList();
        cartItemList.stream().forEach(cartItem -> {
            totalAmount += cartItem.getPrice()*cartItem.getTotal();
        });
        return totalAmount;
    }

    //删除一本书
    public boolean upOneBook(Integer bookId) {
        if (cartItemMap.containsKey(bookId)) {
            CartItem cartItem = cartItemMap.get(bookId);
            Integer total = cartItem.getTotal();
            cartItem.setTotal(total + 1);
            return true;
        }
        return false;
    }

    public boolean downOneBook(Integer bookId) {
        if (cartItemMap.containsKey(bookId)) {
            CartItem cartItem = cartItemMap.get(bookId);
            if (cartItem.getTotal()>0){
                Integer total = cartItem.getTotal();
                cartItem.setTotal(total - 1);
                return true;
            }
        }
        return false;
    }
}
