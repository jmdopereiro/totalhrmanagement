package com.thrm.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.thrm.services.ServiciosGlobales;


public class AuthenticatorInterceptor implements Interceptor {
	
	private ServiciosGlobales serviciosGlobales;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {

		if (serviciosGlobales.comprobarLogin())
			return invocation.invoke();
		else
			return "LOGIN";
	}

	public ServiciosGlobales getServiciosGlobales() {
		return serviciosGlobales;
	}

	public void setServiciosGlobales(ServiciosGlobales serviciosGlobales) {
		this.serviciosGlobales = serviciosGlobales;
	}

}