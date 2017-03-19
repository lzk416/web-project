package com.restrant.action;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.OrderDtsBiz;
import com.restrant.entity.CartItemBean;
import com.restrant.entity.Orderdts;
import com.restrant.entity.Orders;
import com.restrant.entity.Users;

public class OrdersAction extends ActionSupport implements RequestAware,SessionAware{
	OrderDtsBiz orderDtsBiz;

	public void setOrderDtsBiz(OrderDtsBiz orderDtsBiz) {
		this.orderDtsBiz = orderDtsBiz;
	}
	public String addOrders() {
		Orders orders = new Orders();
		orders.setOrderState("未处理");
		orders.setOrderTime(new Date());
		Users user = (Users) session.get("user");
		orders.setUsers(user);
		orders.setOrderPrice((Double)session.get("sumPrice"));
		Map cart = (Map) session.get("cart");
		Iterator iter = cart.keySet().iterator();
		while (iter.hasNext()) {
			Object key = iter.next();
			CartItemBean cartItem = (CartItemBean) cart.get(key);
			Orderdts orderDts= new Orderdts();
			orderDts.setMeal(cartItem.getMeal());
			orderDts.setMealCount(cartItem.getQuantity());
			orderDts.setMealPrice(cartItem.getMeal().getMealPrice());
			orderDts.setOrders(orders);
			orderDtsBiz.addOrderDts(orderDts);
		}
		session.remove("cart");
		return "show";
	}
	
	Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	Map<String, Object> request;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
