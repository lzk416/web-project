package com.restrant.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.restrant.biz.OrderDtsBiz;
import com.restrant.biz.OrdersBiz;
import com.restrant.entity.CartItemBean;
import com.restrant.entity.Orderdts;
import com.restrant.entity.Orders;
import com.restrant.entity.Pager;
import com.restrant.entity.Users;

public class OrdersAction extends ActionSupport implements RequestAware,SessionAware{
	OrderDtsBiz orderDtsBiz;
	int oid;
	private Orders orders;
	

	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	private Pager pager;
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public void setOrderDtsBiz(OrderDtsBiz orderDtsBiz) {
		this.orderDtsBiz = orderDtsBiz;
	}
	OrdersBiz ordersBiz;
	
	public void setOrdersBiz(OrdersBiz ordersBiz) {
		this.ordersBiz = ordersBiz;
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
	public String toMyOrders(){
		Users user = (Users) session.get("user");
		List myOrdersList = ordersBiz.getOrdersByUsersId(user.getId());
		request.put("myOrdersList", myOrdersList);
		return "myorders";
	}
	public String toOrdersDetails() {
		List ordersDtsList= orderDtsBiz.getOrdersDtsByOid(oid);
		request.put("ordersDtsList", ordersDtsList);
		return "toOrdersDetails";
	}
	public String deleteOrders(){
		ordersBiz.deleteOrdersByOid(oid);
		return "toMyOrders";
	}
	Map<String, Object> session;

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	Map<String, Object> request;

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public String toManageOrders(){
		int curPage=1;
		if (pager!=null) {
			curPage = pager.getCurPage();
		}
		List ordersList =null;
		if (orders!=null) {
			ordersList =ordersBiz.getOrdersByConditions(orders, curPage);
			pager=ordersBiz.getPageOfOrders(orders);
			if (orders.getOid()!=null) {
				request.put("oid", orders.getOid());
			}
			if ((orders.getOrderState()!=null)&&!orders.getOrderState().equals("")) {
				request.put("orderState", orders.getOrderState());
			}else {
				ordersList = ordersBiz.getAllOrders(curPage);
				pager=ordersBiz.getPagerOfOrders();
				
			}
		}
		pager.setCurPage(curPage);
		request.put("ordersList", ordersList);
		return "manageorders";
	}
	public String handleOrders(){
		Orders orders = ordersBiz.getOrdersByOid(oid);
		orders.setOrderState("已处理");
		ordersBiz.handleOrders(orders);
		return "toManageOrders";
	}
}
