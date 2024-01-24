package jat.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import jat.dao.CustomerDAO;
import jat.dto.Customer;

@SessionScoped
@Named
public class CustomerController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Customer editedCustomer;
	
	private Customer loginCustomer;
	
	private boolean isLoginCus;
	
	private boolean isAdminLogin;
	
	private boolean isUsersLogin;
	
	public boolean isUsersLogin() {
		return isUsersLogin;
	}

	public void setUserLogin(boolean isUserLogin) {
		this.isUsersLogin = isUserLogin;
	}

	public boolean isAdminLogin() {
		return isAdminLogin;
	}

	public void setAdminLogin(boolean isAdminLogin) {
		this.isAdminLogin = isAdminLogin;
	}

	public boolean isLoginCus() {
		return isLoginCus;
	}

	public void setLoginCus(boolean isLoginCus) {
		this.isLoginCus = isLoginCus;
	}

	private boolean isLogoutCus;
	
	public boolean isLogoutCus() {
		return isLogoutCus;
	}

	public void setLogoutCus(boolean isLogoutCus) {
		this.isLogoutCus = isLogoutCus;
	}

	public Customer getLoginCustomer() {
		return loginCustomer;
	}

	public void setLoginCustomer(Customer loginCustomer) {
		this.loginCustomer = loginCustomer;
	}

	public Customer getEditedCustomer() {
		return editedCustomer;
	}

	public void setEditedCustomer(Customer editedCustomer) {
		this.editedCustomer = editedCustomer;
	}

	@Inject
	private CustomerDAO customerDAO;
	
	public CustomerController() {
		isLoginCus = false;
		isLogoutCus = true;
		isAdminLogin = false;
		isUsersLogin = false;
	}
	@PostConstruct
	public void init() {
		
		Customer admin = new Customer();
		admin.setId(1);
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("pha0027@vsb.cz");
		admin.setPhone("7473342306");
		admin.setIsLogin(false);
		admin.setRole(0);
		customerDAO.save(admin);
		
		
	}
	
	public List<Customer> getAllCustomers() {
		return customerDAO.getAll(); 
	}

	public String save() {
		editedCustomer.setRole(1);
		customerDAO.save(editedCustomer);
		editedCustomer = null;
		return "index";
	}
	public String index() {
		return "index";
	}
	
	public String loginPage() {
		HttpSession s = (HttpSession) (FacesContext.getCurrentInstance().getExternalContext().getSession(true));
		Customer customer_login = (Customer)s.getAttribute("loginCustomer");
		
		if(customer_login == null) {
			loginCustomer = new Customer();
			return "login";
		}
		else {
			loginCustomer = customer_login;
			return "adminPage";
		}
		
	}
	
	public String logout() {
		HttpSession s = (HttpSession) (FacesContext.getCurrentInstance().getExternalContext().getSession(true));
		
		s.setAttribute("loginCustomer", null);
		loginCustomer = null;
		isLoginCus = false;
		isLogoutCus = true;
		isAdminLogin = false;
		isUsersLogin = false;
		return "index";
	}
	
	public String userLogin() {
		HttpSession s = (HttpSession) (FacesContext.getCurrentInstance().getExternalContext().getSession(true));
		Customer cus = customerDAO.findbyUsername(loginCustomer.getUsername().trim(), loginCustomer.getPassword().trim());
		
		if(cus == null) {
			return "login";
		}
		else {
			isLoginCus = true;
			isLogoutCus = false;
			s.setAttribute("loginCustomer", cus);
			
			if(cus.getRole() == 0) {
				isAdminLogin = true;
				return "adminPage";
			}
			else{
				isUsersLogin = true;
				return "index";
			}
		}
	}
	
	public String register() {
		editedCustomer = new Customer();
		
		if(loginCustomer == null) {
			return "register";
		}
		else {
			if(loginCustomer.getUsername() == null) {
				return "register";
			}
			if(loginCustomer.getRole() == 0) {
				return "editCustomer";
			}
			else {
				return "index";
			}
		}
		
	}
	
	public String saveCustomer() {
		customerDAO.save(editedCustomer);
		editedCustomer = null;
		return "userManage";
	}
	
	public String customerManage() {
		return "userManage";
	}
	
	public String editCustomer(Customer edit) {
		editedCustomer = edit;
		return "editCustomer";
	}
	
	public String removeCustomer(Customer edit) {
		customerDAO.delete(edit);
		editedCustomer = null;
		return "userManage";
	}
}
