package com.company.dao.factory;

import com.company.dao.idao.IEmpDao;
import com.company.dao.idao.ILoginRegistryDao;
import com.company.dao.idao.IProductDao;
import com.company.dao.impl.DaoEmpImpl;
import com.company.dao.impl.DaoLoginRegistryImpl;
import com.company.dao.impl.DaoProductImpl;

public class DaoFactory {
	public static IProductDao getProductInstance(){
		return new DaoProductImpl();
	}
	public static ILoginRegistryDao getLoginRegistryInstance(){
		return new DaoLoginRegistryImpl();
	}
	public static IEmpDao getEmpInstance(){
		return new DaoEmpImpl();
	}
}
