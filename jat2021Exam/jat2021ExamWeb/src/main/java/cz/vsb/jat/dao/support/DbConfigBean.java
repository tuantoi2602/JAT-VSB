package cz.vsb.jat.dao.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class DbConfigBean {

	@PersistenceContext
	private EntityManager em;

	public Map<String, String> getDBInfo() {
		Map<String, String> info = new HashMap<>();
		Map<String, Object> props = em.getProperties();
		Metamodel mm = em.getMetamodel();
		mm.getEntities();
		for (Entry<String, Object> entry : props.entrySet()) {
			info.put(entry.getKey(), entry.getValue().toString());
		}
		return info;
	}

	public DBResult getSchemaList() {
		DBResult result = new DBResult();
		result.setHeader(Arrays.asList("Entity", "Java Type", "Attributes"));
		for(EntityType<?> entity : em.getMetamodel().getEntities()) {
			result.getValues().add(Arrays.asList(entity.getName(), entity.getJavaType().getCanonicalName(), entity.getAttributes().stream().map(a -> a.getName() + ": " + a.getJavaType().getCanonicalName()).collect(Collectors.joining("<br/>"))));
		}
		return result;
	}

	public static class DBResult {
		private List<String> header = new ArrayList<>();
		private List<List<String>> values = new ArrayList<>();

		public List<String> getHeader() {
			return header;
		}

		public void setHeader(List<String> header) {
			this.header = header;
		}

		public List<List<String>> getValues() {
			return values;
		}

		public void setValues(List<List<String>> values) {
			this.values = values;
		}

	}
}
