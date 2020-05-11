package com.project.repository;

import com.project.dto.Container;
import com.project.dto.dao.Repository;

import java.util.ArrayList;

public class ContainerDB {

	Repository<Container> containerRepository;
	public ArrayList<Container> containers;
	
	public ContainerDB() {
		super();
		containerRepository = new ContainerRepository();
		containers = new ArrayList<>();
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


	public ArrayList<Container> availableContainerAt (String portOfOrigin){
		
		ArrayList<Container> result = new ArrayList<>();
		for (Container container : containers) {
			if (!(container.getCurrentPosition() == null)) {
				if (container.getCurrentPosition().equals(portOfOrigin) && !container.getInJourney()) {
					result.add(container);

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
		for (Container container : containers) {
			if (ID.equals(container.getContainerID())) {
				return container;
			}
		}
		return null;
	}
}
