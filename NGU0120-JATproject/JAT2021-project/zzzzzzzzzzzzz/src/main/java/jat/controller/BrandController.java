package jat.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jat.dao.BrandDAO;
import jat.dto.Brand;

@SessionScoped
@Named
public class BrandController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Brand editeBrand;

	public Brand getEditeBrand() {
		return editeBrand;
	}

	public void setEditeBrand(Brand editeBrand) {
		this.editeBrand = editeBrand;
	}
	
	@Inject
	private BrandDAO brandDAO;
	
	public List<Brand> getAllBrands() {
		return brandDAO.getAll();
	}
	
	public String BrandManage() {
		return "brandManage";
	}
	
	public String newBrand() {
		editeBrand = new Brand();
		return "editBrand";
	}
	
	public String save() {
		brandDAO.save(editeBrand);
		editeBrand = null;
		return "brandManage";
	}
	
	public String editBrand(Brand edit) {
		editeBrand = edit;
		return "editBrand";
	}
	
	public String removeBrand(Brand edit) {
		brandDAO.delete(edit);
		editeBrand = null;
		return "brandManage";
	}
}
