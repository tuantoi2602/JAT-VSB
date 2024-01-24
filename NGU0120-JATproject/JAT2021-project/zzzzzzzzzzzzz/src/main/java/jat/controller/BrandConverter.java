package jat.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import jat.dao.BrandDAO;
import jat.dto.Brand;



@ApplicationScoped
@FacesConverter(forClass = Brand.class, managed = true)
public class BrandConverter implements Converter<Brand>{

	@Inject
	private BrandDAO brandDAO;
	
	@Override
	public Brand getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if ("null".equals(value) || value == null || value.isBlank()) {
			return null;
		}
		int id = Integer.parseInt(value);
		return brandDAO.find(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Brand value) {
		// TODO Auto-generated method stub
		if (value == null) {
			return "null";
		}
		return Integer.toString(value.getId());
	}
	
}
