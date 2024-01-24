package cz.vsb.jat;

import java.util.Hashtable;

import javax.naming.Context;

public class LdapInfo {

	public static void main(String[] args) {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldaps://ldap.vsb.cz/");
		env.put(Context.SECURITY_AUTHENTICATION, "none");

	}
}
