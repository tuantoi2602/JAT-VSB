package jat.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jat.dao.ShoeDAO;
import jat.dto.Shoe;



@SessionScoped
@Named
public class ShoeController implements Serializable {
	
	private Shoe editedShoe;

	public Shoe getEditedShoe() {
		return editedShoe;
	}

	public void setEditedShoe(Shoe editedShoe) {
		this.editedShoe = editedShoe;
	}
	
	@Inject
	private ShoeDAO shoeDAO;
	
	public List<Shoe> getAllShoes() {
		return shoeDAO.getAll();
	}
	
	public String shoeManage() {
		return "shoeManage";
	}
	
	public String newShoe() {
		editedShoe = new Shoe();
		return "editShoe";
	}
	
	public String save() {
		shoeDAO.save(editedShoe);
		editedShoe = null;
		return "shoeManage";
	}
	
	public String editShoe(Shoe edit) {
		editedShoe = edit;
		return "editShoe";
	}
	
	public String removeShoe(Shoe edit) {
		shoeDAO.delete(edit);
		editedShoe = null;
		return "shoeManage";
	}
	
	public String viewAllShoe() {
		return "orderShoe";
	}
	
}
