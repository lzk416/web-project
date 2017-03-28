package com.restrant.biz;

import java.util.List;

import com.restrant.entity.Orders;
import com.restrant.entity.Pager;

public interface OrdersBiz {
	public List getOrdersByUsersId(int userId);
	public void deleteOrdersByOid(int oid);
	public List getAllOrders(int page);
	public Pager getPagerOfOrders();
	//这个添加有页数的限制
	public List getOrdersByConditions(Orders condition,int page );
	public Pager getPageOfOrders(Orders condition);
	public void handleOrders(Orders orders);
	public Orders getOrdersByOid(int oid);
	
}
