package com.restrant.biz.Impl;

import com.restrant.dao.OrderDtsDao;
import com.restrant.entity.Orderdts;

public class OrderDtsBizImpl implements OrderDtsDao {
	OrderDtsDao orderDtsDao;
	
	public void setOrderDtsDao(OrderDtsDao orderDtsDao) {
		this.orderDtsDao = orderDtsDao;
	}

	public void addOrderDts(Orderdts dts) {
		orderDtsDao.addOrderDts(dts);
	}
	
}
