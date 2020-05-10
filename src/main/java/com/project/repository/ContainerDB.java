package com.project.repository;

import com.project.dto.Container;
import com.project.dto.dao.Repository;

import java.util.ArrayList;

public class ContainerDB {

	Repository<Container> containerRepository;
	public ArrayList<Container> containers = new ArrayList<Container>();
	
	public ContainerDB() {
		super();
		containerRepository = new ContainerRepository();
		containers = new ArrayList<Container>();
	}

	// load from database
	public void findAll() {
		containers = containerRepository.findAll();
	}

	// this method needs to be called when application will end. For the entities to be written to database
	public void writeAllToDatabase() {
		containerRepository.putAllInDatabase(containers);
	}
	
	public ArrayList<Container> getContainers() {
		return containers;
	}

	public void setContainers(ArrayList<Container> containers) {
		this.containers = containers;
	}
	
	
	public ArrayList<Container> availableContainerAt (String portOfOrigin){
		
		ArrayList<Container> result = new ArrayList<Container>();
		for(int i = 0 ; i<containers.size(); i++) {
			if (!(this.containers.get(i).getCurrentPosition()==null)) {
				if( this.containers.get(i).getCurrentPosition().equals(portOfOrigin) && this.containers.get(i).getInJourney()==false) {
					result.add(this.containers.get(i));
				
				}
			}
		}
		
		return result;
	 }
	
	
	public void giveID(Container container) {
		String prefix = "CO";
		String number = Integer.toString(this.containers.size()+1);
		String zeroes = "0".repeat(6-number.length());
		String id = prefix + zeroes + number;
		container.setContainerID(id);
		
		
	}
	public Container find(String ID) {
		for (int i =0;i<containers.size();i++) {
			if (ID.equals(containers.get(i).getContainerID())){
				return containers.get(i);
			}
		}
		return null;
	}
}
