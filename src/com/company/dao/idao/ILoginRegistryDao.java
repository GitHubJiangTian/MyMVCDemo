package com.company.dao.idao;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;

public interface ILoginRegistryDao {

	void registry(Login login,Detail detail) throws Exception;

	Login login(Login login) throws Exception;
	
}
