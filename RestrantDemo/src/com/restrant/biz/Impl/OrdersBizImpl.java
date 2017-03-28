package com.restrant.biz.Impl;

import java.util.List;

import com.restrant.biz.OrdersBiz;
import com.restrant.dao.OrdersDAO;
import com.restrant.entity.Orders;
import com.restrant.entity.Pager;

public class OrdersBizImpl implements OrdersBiz{
	OrdersDAO ordersDAO;
	
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	public List getOrdersByUsersId(int userId) {
		return ordersDAO.getOrdersByUserId(userId);
	}

	public void deleteOrdersByOid(int oid) {
		Orders orders = ordersDAO.getOrdersByOid(oid);
		ordersDAO.deleteOrders(orders);
	}

	public List getAllOrders(int page) {
		return ordersDAO.getAllOrders(page);
	}

	public Pager getPagerOfOrders() {
		int count =ordersDAO.getCountOfAllOrders();
		Pager pager = new Pager();
		pager.setPerPageRows(6);
		pager.setPageCount(count);
		return pager;
	}

	public List getOrdersByConditions(Orders condition, int page) {
		return ordersDAO.getOrdersByCondition(condition, page);
	}

	public Pager getPageOfOrders(Orders condition) {
		int count = ordersDAO.getCountOfOrders(condition);
		Pager pager =new Pager();
		pager.setPerPageRows(6);
		pager.setRowCount(count);
		return pager;
	}

	public void handleOrders(Orders orders) {
		ordersDAO.updateOrders(orders);
	}
	public Orders getOrdersByOid(int oid) {
		return ordersDAO.getOrdersByOid(oid);
	}


}
