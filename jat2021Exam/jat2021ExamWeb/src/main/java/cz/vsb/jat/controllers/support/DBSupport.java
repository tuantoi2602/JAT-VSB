package cz.vsb.jat.controllers.support;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.vsb.jat.dao.support.DbConfigBean;
import cz.vsb.jat.dao.support.DbConfigBean.DBResult;

@Named
@RequestScoped
public class DBSupport {
	
	@Inject
	private DbConfigBean testConfigSB;

	public Map<String, String> getDBInfo() {
		return testConfigSB.getDBInfo();
	}

	public List<String> getDBInfoKeys() {
		return new ArrayList<>(testConfigSB.getDBInfo().keySet());
	}

	public DBResult getEntityList() {
		return testConfigSB.getSchemaList();
	}

}
