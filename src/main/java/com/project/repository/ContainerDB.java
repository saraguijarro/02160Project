package com.project.repository;

import java.util.ArrayList;

import com.project.dto.Container;



public class ContainerDB {
	
	
	public ArrayList<Container> containers;
	
	public ContainerDB() {
		super();
		containers = new ArrayList<Container>();
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
			if( this.containers.get(i).getCurrentPosition().equals(portOfOrigin) && this.containers.get(i).getInJourney()==false) {
				result.add(this.containers.get(i));
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
}
