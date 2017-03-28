package com.restrant.dao;

import java.util.List;

import com.restrant.entity.Orderdts;

public interface OrderDtsDAO {
	public void addOrderDts(Orderdts dts);
	public List getOrderDtsByOid(int oid);
}
