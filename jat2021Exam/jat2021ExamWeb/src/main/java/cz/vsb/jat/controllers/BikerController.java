package cz.vsb.jat.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import cz.vsb.jat.dto.Biker;
import cz.vsb.jat.dto.Trip;
import cz.vsb.jat.fakedb.BikerDB;
import cz.vsb.jat.fakedb.TripDB;

@Named
@SessionScoped
public class BikerController implements Serializable {

	private static final long serialVersionUID = -7951644021955391520L;

	@Inject
	private BikerDB bikerDB;
	@Inject
	private TripDB tripDB;

	private Biker editedBiker;

	public Biker getEditedBiker() {
		return editedBiker;
	}

	public void setEditedBiker(Biker editedBiker) {
		this.editedBiker = editedBiker;
	}

	public List<Biker> getAllBikers() {
		return bikerDB.getAll();
	}

	public List<Trip> getAllTrips() {
		return tripDB.getAll();
	}

	public String edit(Biker biker) {
		editedBiker = biker;
		return "task2_editBiker";
	}

	public String createNew() {
		editedBiker = new Biker();
		return "task2_editBiker";
	}

	public String delete(Biker biker) {
		bikerDB.remove(biker.getId());
		return "task2";
	}

	public String reset() {
		bikerDB.clear();
		bikerDB.init();
		return "task2";
	}

	public String save() {
		bikerDB.save(editedBiker);
		return "task2";
	}

}
