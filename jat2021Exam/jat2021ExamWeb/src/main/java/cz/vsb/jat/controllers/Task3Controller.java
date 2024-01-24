/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.vsb.jat.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cz.vsb.jat.dao.Task3Dao;
import cz.vsb.jat.entities.Train;
import cz.vsb.jat.entities.Wagon;

/**
 *
 * @author jez04
 */
@Named
@ApplicationScoped
public class Task3Controller  implements Serializable{

	private static final long serialVersionUID = 562622862813085013L;

	@Inject
    protected Task3Dao task3Dao;
    
    protected Random random = new Random();
    
    protected Long trainSelectedId;
    protected Long wagonSelectedId;
    
    protected Train selected = null;
    
    /** Creates a new instance of Task22MB */
    public Task3Controller() {
    }
    
    public List<Train> getAllTrains(){
        return task3Dao.getAllTrains();
    }

    public List<Wagon> getAllWagons(){
        return task3Dao.getAllWagons();
    }
    
    public String generateTrain(){
    	Train t = new Train();
        t.setName("Train " + random.nextInt(100));
        task3Dao.insertNewTrain(t);
        return "";
    }

    public String generateWagon(){
    	Wagon w = new Wagon();
        w.setCapacity(random.nextInt(100)+10);
        task3Dao.insertNewWagon(w);
        return "";
    }

    public Long getTrainSelectedId() {
        return trainSelectedId;
    }

    public void setTrainSelectedId(Long trainSelectedId) {
        this.trainSelectedId = trainSelectedId;
    }

    public Long getWagonSelectedId() {
        return wagonSelectedId;
    }

    public void setWagonSelectedId(Long wagonSelectedId) {
        this.wagonSelectedId = wagonSelectedId;
    }
    
    public String assign(Wagon w, Train t){
        task3Dao.assign(w.getId(), t.getId());
        return "";
    }
    
    public String showWagons(Train t){
    	selected = t;
    	return "task3_showWagons";
    }

	public Train getSelected() {
		return selected;
	}

	public void setSelected(Train selected) {
		this.selected = selected;
	}
    
    public List<Wagon> getWagonsOfSelectedTrain(){
    	return task3Dao.getWagonsOfTrain(selected.getId());
    }
}
