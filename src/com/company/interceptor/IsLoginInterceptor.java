package com.company.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class IsLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "unlogin";
		//获得session对象
		if (ActionContext.getContext().getSession().get("username") != null) {
			result = invocation.invoke();
		}
		return result;
	}

}
