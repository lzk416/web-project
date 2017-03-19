package com.restrant.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.restrant.entity.Admin;
import com.restrant.entity.Users;

public class AuthorityInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String name=invocation.getInvocationContext().getName();
		if (name.equals("validateLogin")) {
			return invocation.invoke();
		}else {
			//取得session
			ActionContext ac = invocation.getInvocationContext();
			Map session = (Map)ac.get(ServletActionContext.SESSION);
			if (session==null) {
				return "login";
			}else {
				Users user = (Users) session.get("user");
				if (user ==null) {
					Admin admin = (Admin) session.get("admin");
					if (admin==null) {
						return "login";
					}else {
						return invocation.invoke();
					}
				}else {
					return invocation.invoke();
				}
			}
		}
	}
}
