package com.restrant.biz;

import java.util.List;

import com.restrant.entity.Orderdts;

public interface OrderDtsBiz {
	public void addOrderDts(Orderdts dts);
	public List getOrdersDtsByOid(int oid);
	
	
}
