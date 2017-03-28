package com.restrant.biz.Impl;

import java.util.List;


import com.restrant.biz.OrderDtsBiz;
import com.restrant.dao.OrderDtsDAO;
import com.restrant.entity.Orderdts;

public class OrderDtsBizImpl implements OrderDtsBiz {
	OrderDtsDAO orderDtsDAO;
	
	public void setOrderDtsDao(OrderDtsDAO orderDtsDao) {
		this.orderDtsDAO = orderDtsDao;
	}

	public void addOrderDts(Orderdts dts) {
		orderDtsDAO.addOrderDts(dts);
	}

	public List getOrdersDtsByOid(int oid) {
		return orderDtsDAO.getOrderDtsByOid(oid);
	}
	
}
