package cz.vsb.jat.controllers.support;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

@Named
@RequestScoped
public class JNDISupport {

	public List<JNDIElement> getJndiList() {
		List<JNDIElement> resultList = new ArrayList<>();
		try {
			InitialContext ctx = new InitialContext();
			listEnum((Context)ctx.lookup("java:global"), "java:global", resultList);
			listEnum((Context)ctx.lookup("java:app"), "java:app", resultList);
			listEnum((Context)ctx.lookup("java:module"), "java:module", resultList);
			listEnum((Context)ctx.lookup("java:"), "java:", resultList);
		} catch (NamingException | NumberFormatException e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public void listEnum(Context ctx, String prefix, List<JNDIElement> resultList) throws NamingException {
		NamingEnumeration<NameClassPair> pair = ctx.list("");
		try {
			while(pair.hasMore()) {
				NameClassPair b = pair.next();
				Object value = "";
				try {
					value = ctx.lookup(b.getName());
				} catch (NamingException ex) {
					value = "EXCEPTION: " + ex.getMessage();
				} 
				boolean isContext =value instanceof Context;
				resultList.add(new JNDIElement(prefix + "/" + b.getName(), b.getClassName(),value.toString(), isContext));
				if(isContext) {
					listEnum((Context)ctx.lookup(b.getName()), prefix+"/" + b.getName(), resultList);
				}
			}
		} catch (NameNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	public static class JNDIElement{
		
		private String name;
		private String className;
		private String toStringValue;
		private boolean context;
		
		
		public JNDIElement(String name, String className, String toStringValue, boolean context) {
			super();
			this.name = name;
			this.className = className;
			this.toStringValue = toStringValue;
			this.context = context;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getToStringValue() {
			return toStringValue;
		}
		public void setToStringValue(String toStringValue) {
			this.toStringValue = toStringValue;
		}
		public boolean isContext() {
			return context;
		}
		public void setContext(boolean context) {
			this.context = context;
		}
		
		
	}
}
