package com.restrant.dao;

import java.util.List;

import com.restrant.entity.Orders;

public interface OrdersDAO {
	public List getOrdersByUserId(int userId);
	public Orders getOrdersByOid(int oid);
	public void deleteOrders(Orders orders);
	public List getAllOrders(int page);
	public 	Integer getCountOfAllOrders();
	public List getOrdersByCondition(Orders condition,int page);
	public Integer getCountOfOrders(Orders condition);
	public void updateOrders(Orders orders);
}
