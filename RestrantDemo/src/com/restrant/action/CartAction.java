package com.restrant.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.MealBiz;
import com.restrant.biz.MealSeriesBiz;
import com.restrant.entity.CartItemBean;
import com.restrant.entity.Meal;

public class CartAction  extends ActionSupport implements SessionAware{
	private Integer mealId;

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public Integer getMealId() {
		return mealId;
	}
	int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	MealBiz mealBiz;

	public void setMealBiz(MealBiz mealBiz) {
		this.mealBiz = mealBiz;
	}
	MealSeriesBiz mealSeriesBiz;

	public void setMealSeriesBiz(MealSeriesBiz mealSeriesBiz) {
		this.mealSeriesBiz = mealSeriesBiz;
	}
	Map<String, Object> session;
   
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String addtoshopcart() throws Exception{
		//从session中取，如果session不存的的话，则返回null,下面还有一个if（cart==null）的判断。用于创建cart
		Map cart = (Map) session.get("cart");
		Meal meal=mealBiz.getMealByMealId(mealId);
		if (cart==null) {
			cart= new HashMap();
			session.put("cart", cart);
		}
		//判断餐品是否在购物车中
		CartItemBean cartItem = (CartItemBean) cart.get(meal.getMealId());
		if (cartItem!=null) {
			cartItem.setQuantity(cartItem.getQuantity()+1);
		}else {
			cart.put(meal.getMealId(), new CartItemBean(meal,1));
		}
		return "shopCart";
	}
	public String updateSelectedQuantity() throws Exception{
		Map cart = (Map) session.get("cart");
		CartItemBean cartItem = (CartItemBean) cart.get(mealId);
		cartItem.setQuantity(quantity);
		return "shopCart";
	}
	public String deleteSelectedOrders(){
		Map cart = (Map) session.get("cart");
		cart.remove(mealId);
		return "shopCart";
	}
	public String clearCart(){
		Map cart = (Map) session.get("cart");
		cart.clear();
		return "shopCart";
	}
}
